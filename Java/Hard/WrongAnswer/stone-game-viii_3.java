class Solution {
    public int stoneGameVIII(int[] stones) {
        
        int n = stones.length;
        int[] dp = new int[n];
        dp[n - 1] = stones[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + stones[i];
        }
        int[] dp2 = new int[n];
        dp2[0] = dp[0];
        for (int i = 1; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp[i]);
        }
        int res = dp2[0];
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, dp2[i] - dp2[i - 1]);
        }
        return res;
    }
}