class Solution {
public:
    int numRollsToTarget(int n, int k, int target) {
        
        int M = 1e9 + 7;
        vector<vector<int>> dp(n + 1, vector<int>(target + 1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= target; ++j) {
                for (int d = 1; d <= k; ++d) {
                    if (j < d) {
                        break;
                    }
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - d]) % M;
                }
            }
        }
        return dp[n][target];
    }
};