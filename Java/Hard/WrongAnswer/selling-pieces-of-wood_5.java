class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        
        int len = prices.length;
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            int hi = prices[i][0];
            int wi = prices[i][1];
            int pricei = prices[i][2];
            for (int j = m; j >= hi; j--) {
                for (int k = n; k >= wi; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - hi][k - wi] + pricei);
                }
            }
        }
        return dp[m][n];
    }
}