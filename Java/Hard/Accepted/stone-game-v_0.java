class Solution {
    public int stoneGameV(int[] stoneValue) {
        
        int[] sum = new int[stoneValue.length + 1];
        for (int i = 0; i < stoneValue.length; i++) {
            sum[i + 1] = sum[i] + stoneValue[i];
        }
        int[][] dp = new int[stoneValue.length][stoneValue.length];
        for (int i = stoneValue.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < stoneValue.length; j++) {
                for (int k = i; k < j; k++) {
                    int left = sum[k + 1] - sum[i];
                    int right = sum[j + 1] - sum[k + 1];
                    if (left < right) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + left);
                    } else if (left > right) {
                        dp[i][j] = Math.max(dp[i][j], dp[k + 1][j] + right);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][k], dp[k + 1][j]) + left);
                    }
                }
            }
        }
        return dp[0][stoneValue.length - 1];
    }
}