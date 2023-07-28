class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];
        int res = 0;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < m; k++) {
                    if(dp[i - 1][j][k] == -1) continue;
                    for(int d1 = -1; d1 <= 1; d1++) {
                        for(int d2 = -1; d2 <= 1; d2++) {
                            int nj = j + d1;
                            int nk = k + d2;
                            if(nj < 0 || nj >= m || nk < 0 || nk >= m) continue;
                            dp[i][nj][nk] = Math.max(dp[i][nj][nk], dp[i - 1][j][k] + grid[i][nj] + (nj == nk ? 0 : grid[i][nk]));
                            if(i == n - 1) res = Math.max(res, dp[i][nj][nk]);
                        }
                    }
                }
            }
        }
        return res;
    }
}