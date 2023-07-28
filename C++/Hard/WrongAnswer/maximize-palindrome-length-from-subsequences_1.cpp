class Solution {
public:
    int longestPalindrome(string word1, string word2) {
        
        string word = word1 + word2;
        int n = word.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = word[i] == word[i + 1] ? 2 : 1;
        }
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
                if (word[i] == word[j]) {
                    dp[i][j] = max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res = max(res, dp[i][n - 1]);
        }
        return res;
    }
};