class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int t = 1; t <= 2 * n - 2; t++) {
            for (int i = Math.min(n - 1, t); i >= 0; i--) {
                for (int j = Math.min(n - 1, t); j >= 0; j--) {
                    if (grid[i][t - i] == -1 || grid[j][t - j] == -1) {
                        dp[i][j][t] = -1;
                        continue;
                    }
                    int val = grid[i][t - i];
                    if (i != j) {
                        val += grid[j][t - j];
                    }
                    for (int pi = i - 1; pi <= i; pi++) {
                        for (int pj = j - 1; pj <= j; pj++) {
                            if (pi >= 0 && pj >= 0) {
                                dp[i][j][t] = Math.max(dp[i][j][t], dp[pi][pj][t - 1] + val);
                            }
                        }
                    }
                }
            }
        }
        return Math.max(0, dp[n - 1][n - 1][2 * n - 2]);
    }
}