class Solution {
public:
    int numberOfWays(int startPos, int endPos, int k) {
        
        const int MOD = 1e9 + 7;
        vector<vector<long long>> dp(k + 1, vector<long long>(1001, 0));
        dp[0][startPos] = 1;
        for (int i = 1; i <= k; ++i) {
            for (int j = 1; j <= 1000; ++j) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }
        return dp[k][endPos];
    }
};