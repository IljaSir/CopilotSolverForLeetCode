class Solution {
    public int stoneGameVIII(int[] stones) {
        
        int n = stones.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + stones[i - 1];
        }
        int[] dp = new int[n];
        dp[n - 1] = pre[n];
        for (int i = n - 2; i >= 1; i--) {
            dp[i] = Math.max(dp[i + 1], pre[i + 1] - dp[i + 1]);
        }
        return dp[1];
    }
}