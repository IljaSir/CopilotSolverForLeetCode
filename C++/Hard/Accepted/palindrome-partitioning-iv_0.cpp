class Solution {
public:
    bool checkPartitioning(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j == i + 1) {
                    dp[i][j] = s[i] == s[j];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j];
                }
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[0][i - 1] && dp[i][j - 1] && dp[j][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
};