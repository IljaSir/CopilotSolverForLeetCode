class Solution {
    public int minScoreTriangulation(int[] values) {
        
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = 0;
        }
        for (int l = 2; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], 
                                        dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
}