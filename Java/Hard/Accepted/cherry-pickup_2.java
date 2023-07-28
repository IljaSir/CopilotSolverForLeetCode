class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = grid[0][0];
        for (int t = 1; t <= 2 * n - 2; t++) {
            int[][] dp2 = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp2[i], Integer.MIN_VALUE);
            }
            for (int i = Math.max(0, t - (n - 1)); i <= Math.min(n - 1, t); i++) {
                for (int p = Math.max(0, t - (n - 1)); p <= Math.min(n - 1, t); p++) {
                    if (grid[i][t - i] == -1 || grid[p][t - p] == -1) {
                        continue;
                    }
                    int val = grid[i][t - i];
                    if (i != p) {
                        val += grid[p][t - p];
                    }
                    for (int pi = i - 1; pi <= i; pi++) {
                        for (int pj = p - 1; pj <= p; pj++) {
                            if (pi >= 0 && pj >= 0) {
                                dp2[i][p] = Math.max(dp2[i][p], dp[pi][pj] + val);
                            }
                        }
                    }
                }
            }
            dp = dp2;
        }
        return Math.max(0, dp[n - 1][n - 1]);
    }
}