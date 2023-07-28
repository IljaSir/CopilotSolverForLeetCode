class Solution {
public:
    int numRollsToTarget(int n, int k, int target) {
        
        int mod = 1e9 + 7;
        int dp[31][1001] = {0};
        for (int i = 1; i <= k; ++i) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = i; j <= target; ++j) {
                for (int l = 1; l <= k; ++l) {
                    if (j - l < 0) break;
                    dp[i][j] = (dp[i][j] + dp[i-1][j-l]) % mod;
                }
            }
        }
        return dp[n][target];
    }
};