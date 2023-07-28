class Solution {
public:
    int maxProduct(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (s[i] == s[j]) {
                    dp[j][i] = dp[j + 1][i - 1] + 2;
                } else {
                    dp[j][i] = max(dp[j + 1][i], dp[j][i - 1]);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int len1 = dp[0][i] + dp[j + 1][n - 1];
                int len2 = dp[i + 1][j];
                res = max(res, len1 * len2);
            }
        }
        return res;
    }
};