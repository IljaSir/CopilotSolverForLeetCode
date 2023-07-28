class Solution {
public:
    int numWays(int steps, int arrLen) {
        
        const int MOD = 1000000007;
        int maxCol = min(steps, arrLen - 1);
        vector<int> dp(maxCol + 1);
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            vector<int> dp2(maxCol + 1);
            for (int j = 0; j <= maxCol; j++) {
                dp2[j] = dp[j];
                if (j - 1 >= 0) {
                    (dp2[j] += dp[j - 1]) %= MOD;
                }
                if (j + 1 <= maxCol) {
                    (dp2[j] += dp[j + 1]) %= MOD;
                }
            }
            dp = dp2;
        }
        return dp[0];
    }
};