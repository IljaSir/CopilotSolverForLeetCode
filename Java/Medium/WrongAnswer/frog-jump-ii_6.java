class Solution {
    public int maxJump(int[] stones) {
        
        int len = stones.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (stones[j] - stones[i] > dp[i] + 1) {
                    break;
                }
                dp[j] = Math.min(dp[j], Math.max(dp[i], stones[j] - stones[i]));
            }
        }
        return dp[len - 1];
    }
}