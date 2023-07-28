class Solution {
public:
    bool checkPartitioning(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (s[i] == s[i + 1]);
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = (dp[i + 1][j - 1] && s[i] == s[j]);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (dp[0][i] && dp[i + 1][j] && dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
};