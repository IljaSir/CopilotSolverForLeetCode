class Solution {
    public int minScoreTriangulation(int[] values) {
        
        int n = values.length;
        int[][] dp = new int[n][n];
        for(int i = 2; i < n; i++) {
            for(int j = 0; j + i < n; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for(int k = j + 1; k < j + i; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k][j + i] + values[j] * values[k] * values[j + i]);
                }
            }
        }
        return dp[0][n - 1];
    }
}