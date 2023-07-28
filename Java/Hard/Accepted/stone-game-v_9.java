class Solution {
    public int stoneGameV(int[] stoneValue) {
        
        int n = stoneValue.length;
        int[][] dp = new int[n+1][n+1];
        int[] preSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + stoneValue[i];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j + i <= n; j++) {
                int end = j + i;
                for (int k = j+1; k < end; k++) {
                    if (preSum[k] - preSum[j] > preSum[end] - preSum[k]) {
                        dp[j][end] = Math.max(dp[j][end], dp[k][end] + preSum[end] - preSum[k]);
                    } else if (preSum[k] - preSum[j] < preSum[end] - preSum[k]) {
                        dp[j][end] = Math.max(dp[j][end], dp[j][k] + preSum[k] - preSum[j]);
                    } else {
                        dp[j][end] = Math.max(dp[j][end], Math.max(dp[j][k] + preSum[k] - preSum[j],
                                                                   dp[k][end] + preSum[end] - preSum[k]));
                    }
                }
            }
        }
        return dp[0][n];
    }
}