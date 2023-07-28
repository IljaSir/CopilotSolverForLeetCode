class Solution {
    public int minimumLines(int[][] stockPrices) {
        
        int n = stockPrices.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = stockPrices[i][1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int k = j + i;
                for (int l = j; l < k; l++) {
                    if (dp[j][k] > dp[j][l] + dp[l + 1][k]) {
                        dp[j][k] = dp[j][l] + dp[l + 1][k];
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}