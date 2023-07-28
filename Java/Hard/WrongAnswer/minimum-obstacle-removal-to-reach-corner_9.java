class Solution {
    public int minimumObstacles(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] minObstacles = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minObstacles[i], Integer.MAX_VALUE);
        }
        int[][] dirs = new int[][] {{1, 0}, {0, 1}};
        minObstacles[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int obstacles = minObstacles[x][y] + grid[nx][ny];
                    if (obstacles < minObstacles[nx][ny]) {
                        minObstacles[nx][ny] = obstacles;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        return minObstacles[m - 1][n - 1];
    }
}