class Solution {
    public int minMoves(int target, int maxDoubles) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j <= maxDoubles && i - (1 << j) >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - (1 << j)] + 1);
            }
        }
        return dp[target];
    }
}