class Solution {
    public int stoneGameVII(int[] stones) {
        
        int[][] dp = new int[stones.length][stones.length];
        int[] sum = new int[stones.length];
        sum[0] = stones[0];
        for (int i = 1; i < stones.length; i++) {
            sum[i] = sum[i - 1] + stones[i];
        }
        for (int i = stones.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < stones.length; j++) {
                dp[i][j] = Math.max(sum[j] - sum[i] - dp[i + 1][j], sum[j - 1] - (i == 0 ? 0 : sum[i - 1]) - dp[i][j - 1]);
            }
        }
        return dp[0][stones.length - 1];
    }
}