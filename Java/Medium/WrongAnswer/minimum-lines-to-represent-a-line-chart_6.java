class Solution {
    public int minimumLines(int[][] stockPrices) {
        
        int n = stockPrices.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = 1;
            }
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                for(int k = i + 1; k < j; k++) {
                    if((stockPrices[i][1] - stockPrices[j][1]) * (stockPrices[i][0] - stockPrices[k][0]) == (stockPrices[i][1] - stockPrices[k][1]) * (stockPrices[i][0] - stockPrices[j][0])) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] - 1);
                    }
                }
            }
        }
        int res = n;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                res = Math.min(res, dp[i][j] + 1);
            }
        }
        return res;
    }
}