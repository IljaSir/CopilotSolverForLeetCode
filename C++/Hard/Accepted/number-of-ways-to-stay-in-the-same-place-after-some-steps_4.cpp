class Solution {
public:
    int numWays(int steps, int arrLen) {
        
        int mod = 1e9 + 7;
        int n = min(arrLen - 1, steps);
        vector<int> dp(n + 1);
        dp[0] = 1;
        for (int i = 1; i <= steps; ++i) {
            vector<int> dp2(n + 1);
            for (int j = 0; j <= n; ++j) {
                dp2[j] = dp[j];
                if (j - 1 >= 0) dp2[j] = (dp2[j] + dp[j - 1]) % mod;
                if (j + 1 <= n) dp2[j] = (dp2[j] + dp[j + 1]) % mod;
            }
            dp = dp2;
        }
        return dp[0];
    }
};