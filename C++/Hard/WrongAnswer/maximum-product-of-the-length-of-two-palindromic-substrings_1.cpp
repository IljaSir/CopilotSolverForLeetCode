class Solution {
public:
    long long maxProduct(string s) {
        
        int n = s.length();
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
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s[i] == s[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }
        int maxLen = 0;
        int maxLenIdx = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j]) {
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        maxLenIdx = i;
                    }
                }
            }
        }
        int maxLen2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] && maxLenIdx + maxLen - 1 < i || maxLenIdx > j) {
                    maxLen2 = max(maxLen2, j - i + 1);
                }
            }
        }
        return maxLen * maxLen2;
    }
};