class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        
        int mod = 1_000_000_007;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int[] type : types) {
            int count = type[0], mark = type[1];
            for (int i = 1; i <= count; i++) {
                for (int j = mark; j <= target; j++) {
                    dp[j] = (dp[j] + dp[j - mark]) % mod;
                }
            }
        }
        return dp[target];
    }
}