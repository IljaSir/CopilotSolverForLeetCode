class Solution {
public:
    long long maxProduct(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s[i] == s[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = 1;
                }
            }
        }
        long long ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[0][i] && dp[i + 1][j - 1] && dp[j][n - 1]) {
                    ans = max(ans, (long long)(i + 1) * (long long)(n - j));
                }
                if (dp[0][i] && dp[i][j] && dp[j + 1][n - 1]) {
                    ans = max(ans, (long long)(i + 1) * (long long)(n - j - 1));
                }
            }
        }
        return ans;
    }
};