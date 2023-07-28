class Solution {
    public int minMoves(int target, int maxDoubles) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i < target; i++) {
            for (int j = 1; j <= maxDoubles && i * 2 <= target; j++) {
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
                i *= 2;
            }
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }
        return dp[target];
    }
}