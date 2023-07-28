class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        dp[0][0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int nz = z + grid[nx][ny];
                if (nz > k || dp[nx][ny][nz] <= dp[x][y][z] + 1) continue;
                dp[nx][ny][nz] = dp[x][y][z] + 1;
                q.add(new int[]{nx, ny, nz});
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, dp[m-1][n-1][i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}