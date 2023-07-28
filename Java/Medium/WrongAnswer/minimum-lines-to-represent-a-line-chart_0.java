class Solution {
    public int minimumLines(int[][] stockPrices) {
        
        int n = stockPrices.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((long)stockPrices[j][1] * (stockPrices[i][0] - stockPrices[j][0]) <= (long)stockPrices[i][1] * (stockPrices[i][0] - stockPrices[j][0])) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}