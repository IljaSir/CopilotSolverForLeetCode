class Solution {
public:
    int longestPalindrome(string word1, string word2) {
        
        int n = word1.size();
        int m = word2.size();
        string s = word1 + word2;
        int N = s.size();
        vector<vector<int>> dp(N, vector<int>(N, 0));
        int res = 0;
        for (int i = N - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < N; j++) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = m; j < N; j++) {
                if (s[i] == s[j]) {
                    res = max(res, dp[i + 1][j - 1] + 2);
                }
            }
        }
        return res;
    }
};