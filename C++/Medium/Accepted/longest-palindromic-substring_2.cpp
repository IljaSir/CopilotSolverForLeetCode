class Solution {
public:
    string longestPalindrome(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i < n - 1) {
                if (s[i] == s[i + 1]) {
                    dp[i][i + 1] = 1;
                    maxLen = 2;
                    start = i;
                }
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s[i] == s[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    maxLen = len;
                    start = i;
                }
            }
        }
        return s.substr(start, maxLen);
    }
};