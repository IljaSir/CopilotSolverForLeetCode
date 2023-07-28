class Solution {
    public int minMoves(int target, int maxDoubles) {
        
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i = 1; i < target; i++) {
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            for (int j = 1; j <= maxDoubles && i + (1 << j) <= target; j++) {
                dp[i + (1 << j)] = Math.min(dp[i + (1 << j)], dp[i] + j + 1);
            }
        }
        return dp[target];
    }
}