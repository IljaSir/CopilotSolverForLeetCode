class Solution {
public:
    int numWays(int steps, int arrLen) {
        
        int mod = 1000000007;
        int len = min(arrLen, steps + 1);
        vector<int> dp(len, 0);
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            vector<int> ndp(len, 0);
            for (int j = 0; j < len; j++) {
                ndp[j] = dp[j];
                if (j - 1 >= 0) {
                    ndp[j] = (ndp[j] + dp[j - 1]) % mod;
                }
                if (j + 1 < len) {
                    ndp[j] = (ndp[j] + dp[j + 1]) % mod;
                }
            }
            dp = ndp;
        }
        return dp[0];
    }
};