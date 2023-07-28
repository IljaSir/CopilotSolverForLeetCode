class Solution {
    public int stoneGameVIII(int[] stones) {
        
        int n = stones.length;
        int[] prefix = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }
        int[] dp = new int[n];
        dp[n - 1] = prefix[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            dp[i] = Math.max(dp[i + 1], prefix[i] - dp[i + 1]);
        }
        return dp[1];
    }
}