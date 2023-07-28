class Solution {
    public int minScoreTriangulation(int[] values) {
        
        int[][] dp = new int[values.length][values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < values.length; j++) {
                if (j - i == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + values[i] * values[k] * values[j] + dp[k][j]);
                    }
                }
            }
        }
        return dp[0][values.length - 1];
    }
}