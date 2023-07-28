class Solution {
public:
    int distinctSequences(int n) {
        
        int mod = 1e9 + 7;
        vector<vector<int>> dp(n + 1, vector<int>(7, 0));
        for (int i = 1; i <= 6; ++i) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= 6; ++j) {
                for (int k = 1; k <= 6; ++k) {
                    if (j == k) continue;
                    if (__gcd(j, k) == 1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= 6; ++i) {
            ans = (ans + dp[n][i]) % mod;
        }
        return ans;
    }
};