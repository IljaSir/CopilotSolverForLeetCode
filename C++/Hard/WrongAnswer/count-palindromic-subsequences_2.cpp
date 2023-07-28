class Solution {
public:
    int countPalindromes(string s) {
        
        int n = s.size();
        int mod = 1000000007;
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
            if (i < n - 1 && s[i] == s[i + 1]) {
                dp[i][i + 1] = 3;
            } else if (i < n - 1) {
                dp[i][i + 1] = 2;
            }
        }
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;
                if (s[i] == s[j]) {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1) % mod;
                } else {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + mod) % mod;
                }
            }
        }
        return dp[0][n - 1];
    }
};