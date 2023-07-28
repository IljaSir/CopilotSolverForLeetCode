class Solution {
public:
    bool checkPartitioning(string s) {
        
        int n = s.length();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
           if (i < n - 1 && s[i] == s[i ]) {
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
                if (dp[0][i - 1] && dp[i][j - 1] && dp[j

        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s[i] == s[i + 1];
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                dp[i][i + len - 1] = dp[i + 1][i + len - 2] && s[i] == s[i + len - 1];
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (dp[0][i] && dp[i + 1][j] && dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
};