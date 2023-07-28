class Solution {
public:
    int numRollsToTarget(int n, int k, int target) {
        
        vector<vector<int>> dp(n+1, vector<int>(target+1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int kk = 1; kk <= k; kk++) {
                    if (j < kk) continue;
                    dp[i][j] = (dp[i][j] + dp[i-1][j-kk]) % 1000000007;
                }
            }
        }
        return dp[n][target];
    }
};