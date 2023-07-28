class Solution {
public:
    int numberOfWays(int startPos, int endPos, int k) {
        
        int mod = 1000000007;
        vector<vector<long long>> dp(k + 1, vector<long long>(1001, 0));
        dp[0][startPos] = 1;
        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j <= 1000; ++j) {
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                    dp[i][j] %= mod;
                }
                if (j < 1000) {
                    dp[i][j] += dp[i - 1][j + 1];
                    dp[i][j] %= mod;
                }
            }
        }
        return dp[k][endPos];
    }
};