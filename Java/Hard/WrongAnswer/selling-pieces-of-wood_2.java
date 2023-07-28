class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        
        int[][] dp = new int[m + 1][n + 1];
        for (int[] price : prices) {
            for (int i = price[0]; i <= m; i++) {
                for (int j = price[1]; j <= n; j++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - price[0]][j - price[1]] + price[2]);
                }
            }
        }
        return dp[m][n];
    }
}