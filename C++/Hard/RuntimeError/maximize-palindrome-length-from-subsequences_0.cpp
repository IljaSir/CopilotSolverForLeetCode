class Solution {
public:
    int longestPalindrome(string word1, string word2) {
        
        string s = word1 + word2;
        int n = s.length();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = (s[i] == s[i + 1]) ? 2 : 0;
        }
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i + len - 1 < n; ++i) {
                int j = i + len - 1;
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (dp[0][i] + dp[i + 1][j] + dp[j + 1][n - 1] == j - i) {
                    ans = max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
};