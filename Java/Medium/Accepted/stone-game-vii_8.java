class Solution {
    public int stoneGameVII(int[] stones) {
        
        int n = stones.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; ++i) preSum[i] = preSum[i - 1] + stones[i - 1];
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[i][j] = Math.max(preSum[j + 1] - preSum[i + 1] - dp[i + 1][j], preSum[j] - preSum[i] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}