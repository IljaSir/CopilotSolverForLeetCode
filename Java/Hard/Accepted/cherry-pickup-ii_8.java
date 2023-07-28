class Solution {
    public int cherryPickup(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int[][] d : dp) {
            for (int[] d2 : d) {
                Arrays.fill(d2, Integer.MIN_VALUE);
            }
        }
        dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int j2 = j - 1; j2 <= j + 1; j2++) {
                        for (int k2 = k - 1; k2 <= k + 1; k2++) {
                            if (j2 >= 0 && j2 < n && k2 >= 0 && k2 < n) {
                                dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j2][k2]);
                            }
                        }
                    }
                    if (dp[i][j][k] >= 0) {
                        dp[i][j][k] += grid[i][j];
                        if (j != k) {
                            dp[i][j][k] += grid[i][k];
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                ans = Math.max(ans, dp[m - 1][j][k]);
            }
        }
        return ans;
    }
}