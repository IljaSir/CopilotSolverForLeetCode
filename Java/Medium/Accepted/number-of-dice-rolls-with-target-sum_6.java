class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        
        int mod = 1000000007;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j >= l) {
                        dp[i][j] += dp[i - 1][j - l];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}