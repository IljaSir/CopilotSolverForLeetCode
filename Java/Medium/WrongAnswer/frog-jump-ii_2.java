class Solution {
    public int maxJump(int[] stones) {
        
        int n = stones.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[j] - stones[i] > i + 1) {
                    break;
                }
                dp[j] = Math.min(dp[j], dp[i] + stones[j] - stones[i]);
            }
        }
        return dp[n - 1];
    }
}