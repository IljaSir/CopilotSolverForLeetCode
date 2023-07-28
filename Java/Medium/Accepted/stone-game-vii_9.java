class Solution {
    public int stoneGameVII(int[] stones) {
        
        int n = stones.length;
        int[] dp = new int[n];
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + stones[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(sum[j+1] - sum[i+1] - dp[j], sum[j] - sum[i] - dp[j-1]);
            }
        }
        return dp[n-1];
    }
}