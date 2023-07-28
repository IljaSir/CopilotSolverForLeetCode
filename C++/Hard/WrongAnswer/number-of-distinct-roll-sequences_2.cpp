class Solution {
public:
    int distinctSequences(int n) {
        
        int MOD = 1e9 + 7;
        vector<vector<int>> dp(n + 1, vector<int>(6, 0));
        for (int i = 0; i < 6; ++i) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < 6; ++j) {
                for (int k = 0; k < 6; ++k) {
                    if (gcd(j + 1, k + 1) == 1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 6; ++i) {
            ans = (ans + dp[n][i]) % MOD;
        }
        return ans;
    }
};