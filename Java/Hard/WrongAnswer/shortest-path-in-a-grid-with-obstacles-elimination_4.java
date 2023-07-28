class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int obs = cur[2];
                if (r == m - 1 && c == n - 1) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    int nobs = obs + grid[nr][nc];
                    if (nobs > k || visited[nr][nc]) {
                        continue;
                    }
                    queue.add(new int[]{nr, nc, nobs});
                    visited[nr][nc] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}