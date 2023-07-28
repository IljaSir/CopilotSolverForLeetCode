class Solution {
public:
    bool checkPartitioning(string s) {
        
        int n = s.length();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
            if (i < n - 1 && s[i] == s[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                if (s[i] == s[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (dp[0][i - 1] && dp[i][j - 1] && dp[j][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
};