class Solution {
public:
    int numPermsDISequence(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s[i - 1] == 'D') {
                for (int j = i - 1; j >= 0; --j) {
                    dp[i][j] = (dp[i][j + 1] + dp[i - 1][j]) % int(1e9 + 7);
                }
            } else {
                for (int j = 0; j < i; ++j) {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % int(1e9 + 7);
                }
            }
        }
        return dp[n][n - 1];
    }
};