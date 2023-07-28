class Solution {
public:
    string longestNiceSubstring(string s) {
        
        int n = s.size();
        if (n < 2) return "";
        vector<vector<int>> dp(n, vector<int>(n));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; ++i) {
            if (isNice(s[i], s[i + 1])) dp[i][i + 1] = 1;
        }
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;
                if (isNice(s[i], s[j])) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
        for (int len = n; len >= 2; --len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;
                if (dp[i][j]) return s.substr(i, len);
            }
        }
        return "";
    }
};