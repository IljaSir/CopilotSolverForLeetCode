class Solution {
public:
    int numWays(int steps, int arrLen) {
        
        const int MOD = 1000000007;
        int maxColumn = min(arrLen - 1, steps);
        vector<int> dp(maxColumn + 1);
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            vector<int> dpNext(maxColumn + 1);
            for (int j = 0; j <= maxColumn; j++) {
                dpNext[j] = dp[j];
                if (j - 1 >= 0) {
                    dpNext[j] = (dpNext[j] + dp[j - 1]) % MOD;
                }
                if (j + 1 <= maxColumn) {
                    dpNext[j] = (dpNext[j] + dp[j + 1]) % MOD;
                }
            }
            dp = dpNext;
        }
        return dp[0];
    }
};