class Solution {
    public int cherryPickup(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[0][i] + grid[0][j];
            }
        }
        for (int i = 1; i < m; i++) {
            int[][] next = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    next[j][k] = -1;
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dp[j][k] == -1) continue;
                    int val = dp[j][k];
                    if (j > 0) {
                        next[j - 1][k] = Math.max(next[j - 1][k], val + (k == j - 1 ? 0 : grid[i][j - 1]));
                    }
                    next[j][k] = Math.max(next[j][k], val + (k == j ? 0 : grid[i][j]));
                    if (j < n - 1) {
                        next[j + 1][k] = Math.max(next[j + 1][k], val + (k == j + 1 ? 0 : grid[i][j + 1]));
                    }
                    if (k > 0) {
                        next[j][k - 1] = Math.max(next[j][k - 1], val + (j == k - 1 ? 0 : grid[i][k - 1]));
                    }
                    next[j][k] = Math.max(next[j][k], val + (j == k ? 0 : grid[i][k]));
                    if (k < n - 1) {
                        next[j][k + 1] = Math.max(next[j][k + 1], val + (j == k + 1 ? 0 : grid[i][k + 1]));
                    }
                }
            }
            dp = next;
        }
        int res = 0;
    }
}