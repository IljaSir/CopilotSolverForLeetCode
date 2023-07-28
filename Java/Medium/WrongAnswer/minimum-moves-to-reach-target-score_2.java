class Solution {
    public int minMoves(int target, int maxDoubles) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i = 1; i < target; i++) {
            for (int j = 1; j <= maxDoubles && i + j <= target; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
            for (int j = 2; i * j <= target; j++) {
                dp[i * j] = Math.min(dp[i * j], dp[i] + 1);
            }
        }
        return dp[target];
    }
}