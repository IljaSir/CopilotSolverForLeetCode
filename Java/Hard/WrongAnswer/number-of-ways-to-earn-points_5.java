class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        
        int mod = 1000000007;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int[] type : types) {
            for (int i = type[1]; i <= target; i++) {
                dp[i] = (dp[i] + dp[i - type[1]]) % mod;
            }
        }
        return dp[target];
    }
}