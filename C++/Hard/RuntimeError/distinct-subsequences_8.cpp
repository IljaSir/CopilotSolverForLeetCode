class Solution {
public:
    int numDistinct(string s, string t) {
        
        int m = t.size();
        int n = s.size();
        vector<vector<long long>> dp(m+1, vector<long long>(n+1, 0));
        for (int i = 0; i <= n; ++i) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i][j-1];
                if (t[i-1] == s[j-1]) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
};