class Solution {
    public int stoneGameVII(int[] stones) {
        
        int n = stones.length;
        int[] sum = new int[n];
        sum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(sum[j] - sum[i] - dp[i + 1][j], sum[j - 1] - (i > 0 ? sum[i - 1] : 0) - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}