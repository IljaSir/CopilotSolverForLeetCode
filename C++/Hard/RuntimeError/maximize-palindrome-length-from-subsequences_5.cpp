class Solution {
public:
    int longestPalindrome(string word1, string word2) {
        
        int n = word1.size(), m = word2.size();
        string s = word1 + word2;
        vector<vector<int>> dp(n + m, vector<int>(n + m, 0));
        for (int i = 0; i < n + m; ++i) {
            dp[i][i] = 1;
        }
        for (int i = n + m - 1; i >= 0; --i) {
            for (int j = i + 1; j < n + m; ++j) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (word1[i] == word2[j]) {
                    ans = max(ans, dp[i][n + j] + dp[n + j + 1][n + m - 1]);
                }
            }
        }
        return ans;
    }
};