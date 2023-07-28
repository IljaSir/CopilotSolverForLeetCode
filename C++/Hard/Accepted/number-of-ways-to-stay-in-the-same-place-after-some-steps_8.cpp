class Solution {
public:
    int numWays(int steps, int arrLen) {
        
        int M = 1000000007;
        int maxCol = min(steps, arrLen - 1);
        vector<long> dp(maxCol + 1);
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            vector<long> dp2(maxCol + 1);
            for (int j = 0; j <= maxCol; j++) {
                dp2[j] = dp[j];
                if (j - 1 >= 0) {
                    dp2[j] = (dp2[j] + dp[j - 1]) % M;
                }
                if (j + 1 <= maxCol) {
                    dp2[j] = (dp2[j] + dp[j + 1]) % M;
                }
            }
            dp = dp2;
        }
        return dp[0];
    }
};