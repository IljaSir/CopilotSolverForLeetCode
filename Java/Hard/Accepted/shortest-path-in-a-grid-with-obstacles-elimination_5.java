class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k + 1];
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1], obstacles = cur[2];
                if (x == m - 1 && y == n - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    int nObstacles = obstacles + grid[nx][ny];
                    if (nObstacles > k || visited[nx][ny][nObstacles]) {
                        continue;
                    }
                    queue.offer(new int[]{nx, ny, nObstacles});
                    visited[nx][ny][nObstacles] = true;
                }
            }
            step++;
        }
        return -1;
    }
}