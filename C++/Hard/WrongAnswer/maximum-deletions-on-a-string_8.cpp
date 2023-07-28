class Solution {
public:
    int deleteString(string s) {
        
        int n = s.size();
        int dp[n][n];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s[i] == s[i + 1] ? 2 : 1;
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                dp[i][j] = max(dp[i][j - 1], dp[i + 1][j]);
                if (s[i] == s[j]) {
                    dp[i][j] = max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        return n - dp[0][n - 1];
    }
};