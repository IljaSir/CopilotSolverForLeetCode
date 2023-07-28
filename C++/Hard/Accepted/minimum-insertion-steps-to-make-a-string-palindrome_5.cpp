class Solution {
public:
    int minInsertions(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = s[i] == s[i + 1] ? 2 : 1;
        }
        for (int len = 2; len < n; ++len) {
            for (int i = 0; i + len < n; ++i) {
                int j = i + len;
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[0][n - 1];
    }
};