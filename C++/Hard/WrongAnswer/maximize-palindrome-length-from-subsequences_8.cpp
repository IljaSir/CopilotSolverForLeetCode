class Solution {
public:
    int longestPalindrome(string word1, string word2) {
        
        int n1 = word1.size(), n2 = word2.size();
        vector<vector<int>> dp(n1 + n2 + 1, vector<int>(n1 + n2 + 1, 0));
        for (int i = 0; i < n1; ++i) {
            for (int j = 0; j < n2; ++j) {
                if (word1[i] == word2[j]) {
                    dp[i + 1][n1 + 1 + j] = dp[i][n1 + j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= n1 + n2; ++i) {
            for (int j = 0; j <= n1 + n2; ++j) {
                if (i == 0 || j == 0 || i == n1 + n2 || j == n1 + n2) {
                    ans = max(ans, dp[i][j]);
                }
                else if ((i <= n1 && j > n1) || (i > n1 && j <= n1)) {
                    ans = max(ans, dp[i][j] * 2);
                }
            }
        }
        return ans;
    }
};