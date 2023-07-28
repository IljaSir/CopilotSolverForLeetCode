class Solution {
public:
    long long maximumSubsequenceCount(string text, string pattern) {
        
        long long n = text.length();
        long long m = pattern.length();
        long long dp[n + 1][m + 1];
        memset(dp, 0, sizeof(dp));
        for (long long i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (long long i = 1; i <= n; i++) {
            for (long long j = 1; j <= m; j++) {
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