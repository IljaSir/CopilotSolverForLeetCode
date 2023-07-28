class Solution {
public:
    int numWays(int steps, int arrLen) {
        
        int mod = 1e9 + 7;
        arrLen = min(arrLen, steps / 2 + 1);
        vector<int> dp(arrLen, 0);
        dp[0] = 1;
        for (int i = 1; i <= steps; ++i) {
            vector<int> ndp(arrLen, 0);
            for (int j = 0; j < arrLen; ++j) {
                ndp[j] = dp[j];
                if (j - 1 >= 0) {
                    ndp[j] = (ndp[j] + dp[j - 1]) % mod;
                }
                if (j + 1 < arrLen) {
                    ndp[j] = (ndp[j] + dp[j + 1]) % mod;
                }
            }
            dp = ndp;
        }
        return dp[0];
    }
};