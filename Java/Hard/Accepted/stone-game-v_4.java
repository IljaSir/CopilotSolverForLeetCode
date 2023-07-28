class Solution {
    public int stoneGameV(int[] stoneValue) {
        
        int len = stoneValue.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + stoneValue[i];
        }
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                for (int k = i; k < j; k++) {
                    if (sum[k + 1] - sum[i] < sum[j + 1] - sum[k + 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + sum[k + 1] - sum[i]);
                    } else if (sum[k + 1] - sum[i] > sum[j + 1] - sum[k + 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[k + 1][j] + sum[j + 1] - sum[k + 1]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][k], dp[k + 1][j]) + sum[k + 1] - sum[i]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}