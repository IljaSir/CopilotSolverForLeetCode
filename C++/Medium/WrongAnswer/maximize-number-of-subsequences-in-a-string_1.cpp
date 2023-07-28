class Solution {
public:
    long long maximumSubsequenceCount(string text, string pattern) {
        
        int n = text.size();
        int m = pattern.size();
        vector<vector<long long>> dp(n + 1, vector<long long>(m + 1));
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text[i - 1] == pattern[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
};