class Solution {
public:
    int countPalindromes(string s) {
        
        int n = s.size();
        int mod = 1000000007;
        vector<vector<int>> dp(n, vector<int>(n, 0));
        vector<vector<int>> sum(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
            sum[i][i] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j + i < n; ++j) {
                if (s[j] != s[j + i]) {
                    dp[j][j + i] = (sum[j][j + i - 1] - sum[j + 1][j + i] + mod) % mod;
                } else {
                    dp[j][j + i] = (sum[j][j + i - 1] + 1) % mod;
                    if (i >= 2) {
                        dp[j][j + i] = (dp[j][j + i] + dp[j + 1][j + i - 1] + 1) % mod;
                    }
                }
                sum[j][j + i] = (sum[j][j + i - 1] + dp[j][j + i]) % mod;
            }
        }
        return dp[0][n - 1];
    }
};