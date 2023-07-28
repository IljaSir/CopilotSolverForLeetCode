class Solution {
public:
    int maxProduct(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = s[i] == s[i + 1] ? 2 : 1;
        }
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
                if (s[i] == s[j]) {
                    dp[i][j] = max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = max(ans, dp[0][i] * dp[j][n - 1]);
            }
        }
        return ans;
    }
};