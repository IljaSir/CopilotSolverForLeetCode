class Solution {
    public int maxJump(int[] stones) {
        
        int n = stones.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && stones[j] <= stones[i] + n - 1; j++) {
                int cost = Math.max(dp[i], stones[j] - stones[i]);
                dp[j] = Math.min(dp[j], cost);
            }
        }
        return dp[n - 1];
    }
}