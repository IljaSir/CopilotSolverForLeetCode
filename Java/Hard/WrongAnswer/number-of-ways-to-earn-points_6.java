class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        
        int mod = (int)1e9 + 7;
        int n = types.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int[] type = types[i - 1];
            for (int j = type[1]; j <= target; j++) {
                dp[j] = (dp[j] + dp[j - type[1]]) % mod;
            }
        }
        return dp[target];
    }
}