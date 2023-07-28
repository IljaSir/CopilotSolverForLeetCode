class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                int obs = cur[2];
                if (x == m - 1 && y == n - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    int nobs = obs + grid[nx][ny];
                    if (nobs > k || visited[nx][ny]) {
                        continue;
                    }
                    q.add(new int[]{nx, ny, nobs});
                    visited[nx][ny] = true;
                }
            }
            step++;
        }
        return -1;
    }
}