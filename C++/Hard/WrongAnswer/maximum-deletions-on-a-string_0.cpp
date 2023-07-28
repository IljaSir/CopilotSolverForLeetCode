class Solution {
public:
    int deleteString(string s) {
        
        int n = s.length();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (s[j] == s[j - i]) {
                    dp[j - i][j] = dp[j - i + 1][j - 1] + 2;
                } else {
                    dp[j - i][j] = max(dp[j - i + 1][j], dp[j - i][j - 1]);
                }
            }
        }
        return n - dp[0][n - 1];
    }
};