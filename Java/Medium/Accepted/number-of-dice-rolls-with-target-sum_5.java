class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i)
            for (int j = i; j <= target; ++j)
                for (int d = 1; d <= k; ++d)
                    if (j >= d)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - d]) % MOD;
        return dp[n][target];
    }
}