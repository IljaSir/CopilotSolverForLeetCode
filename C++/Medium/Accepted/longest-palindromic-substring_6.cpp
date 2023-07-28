class Solution {
public:
    string longestPalindrome(string s) {
        
        int n = s.length();
        int dp[n][n];
        int maxlen = 1;
        memset(dp, 0, sizeof(dp));
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = 1;
                start = i;
                maxlen = 2;
            }
        }
        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (dp[i + 1][j - 1] && s[i] == s[j]) {
                    dp[i][j] = 1;
                    if (k > maxlen) {
                        start = i;
                        maxlen = k;
                    }
                }
            }
        }
        return s.substr(start, maxlen);
    }
};