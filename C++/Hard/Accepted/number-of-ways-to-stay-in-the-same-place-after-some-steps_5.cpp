class Solution {
public:
    int numWays(int steps, int arrLen) {
        
        const int MOD = 1e9 + 7;
        int maxCol = min(steps, arrLen - 1);
        vector<vector<int>> dp(steps + 1, vector<int>(maxCol + 1));
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxCol; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                }
                if (j + 1 <= maxCol) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MOD;
                }
            }
        }
        return dp[steps][0];
    }
};