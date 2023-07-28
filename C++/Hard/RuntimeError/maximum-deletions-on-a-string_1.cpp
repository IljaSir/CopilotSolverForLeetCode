class Solution {
public:
    int deleteString(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s[i] == s[i + 1] ? 1 : 2;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = 1 + dp[i + 1][j];
                if (s[i] == s[i + 1]) {
                    dp[i][j] = min(dp[i][j], 1 + dp[i + 2][j]);
                }
                for (int k = i + 2; k <= j; k++) {
                    if (s[i] == s[k]) {
                        dp[i][j] = min(dp[i][j], dp[i + 1][k - 1] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
};