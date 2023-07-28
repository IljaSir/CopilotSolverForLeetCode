class Solution {
public:
    int maxProduct(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (s[j] == s[j + i]) {
                    dp[j][j + i] = 2 + dp[j + 1][j + i - 1];
                } else {
                    dp[j][j + i] = max(dp[j + 1][j + i], dp[j][j + i - 1]);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = max(res, dp[0][i] * dp[j][n - 1]);
            }
        }
        return res;
    }
};