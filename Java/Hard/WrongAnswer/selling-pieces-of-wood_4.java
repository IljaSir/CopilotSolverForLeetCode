class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        
        long[][] dp = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] price : prices) {
                    if (price[0] <= i + 1 && price[1] <= j + 1) {
                        dp[i][j] = Math.max(dp[i][j], price[2] + (i + 1 - price[0] >= 0 ? dp[i + 1 - price[0]][j] : 0) + (j + 1 - price[1] >= 0 ? dp[i][j + 1 - price[1]] : 0));
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}