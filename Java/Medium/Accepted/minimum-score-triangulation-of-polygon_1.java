class Solution {
    public int minScoreTriangulation(int[] values) {
        
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (j - i == 1) {
                    dp[i][j] = 0;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n - 1];
    }
}