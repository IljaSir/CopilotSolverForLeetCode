class Solution {
public:
    int countSubstrings(string s) {
        
        int n = s.length();
        int dp[n][n];
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i + 1]) dp[i][i + 1] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if (dp[i + 1][j - 1] == 1 && s[i] == s[j]) {
                    dp[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] == 1) ans++;
            }
        }
        return ans;
    }
};