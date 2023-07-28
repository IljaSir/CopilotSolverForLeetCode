class Solution {
public:
    int numRollsToTarget(int n, int k, int target) {
        
        if (n * k < target) return 0;
        if (n > target) return 0;
        vector<vector<int>> dp(n+1, vector<int>(target+1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= target; ++j) {
                for (int m = 1; m <= k; ++m) {
                    if (j - m >= 0) {
                        dp[i][j] += dp[i-1][j-m];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        return dp[n][target];
    }
};