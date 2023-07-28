class Solution {
public:
    int countPalindromicSubsequence(string s) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int l = 2; l <= n; ++l) {
            for (int i = 0; i < n - l + 1; ++i) {
                int j = i + l - 1;
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                if (s[i] == s[j]) {
                    int k = i + 1;
                    while (k <= j && s[k] != s[i]) {
                        ++k;
                    }
                    if (k > j) {
                        dp[i][j] += 2;
                    } else if (k == j) {
                        dp[i][j] += 1;
                    } else {
                        dp[i][j] -= dp[k + 1][j - 1];
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
};