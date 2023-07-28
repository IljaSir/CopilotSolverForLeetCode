class Solution {
public:
    int maxProduct(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s[i] == s[j]) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (dp[0][i] * dp[j][n - 1] > ans) {
                    ans = dp[0][i] * dp[j][n - 1];
                }
                if (dp[0][j] * dp[i][n - 1] > ans) {
                    ans = dp[0][j] * dp[i][n - 1];
                }
            }
        }
        return ans;
    }
};