class Solution {
public:
    int numRollsToTarget(int n, int k, int target) {
        
        const int M = 1e9 + 7;
        vector<vector<long>> dp(n+1, vector<long>(target+1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= target; ++j) {
                for (int d = 1; d <= k; ++d) {
                    if (j - d >= 0) {
                        dp[i][j] += dp[i-1][j-d];
                        dp[i][j] %= M;
                    }
                }
            }
        }
        return dp[n][target];
    }
};