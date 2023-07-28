class Solution {
public:
    int countSubstrings(string s) {
        
        int n = s.length();
        int dp[n][n];
        memset(dp, 0, sizeof(dp));
        for(int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for(int i = 0; i < n - 1; ++i) {
            if(s[i] == s[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }
        for(int i = 3; i <= n; ++i) {
            for(int j = 0; j < n - i + 1; ++j) {
                int k = j + i - 1;
                if(s[j] == s[k] && dp[j + 1][k - 1] == 1) {
                    dp[j][k] = 1;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                res += dp[i][j];
            }
        }
        return res;
    }
};