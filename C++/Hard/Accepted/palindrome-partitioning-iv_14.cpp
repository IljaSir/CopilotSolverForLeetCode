class Solution {
public:
    bool checkPartitioning(string s) {
        
        int len = s.length();
        vector<vector<bool>> dp(len, vector<bool>(len, false));
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
            if (i < len - 1) {
                dp[i][i + 1] = s[i] == s[i + 1];
            }
        }
        for (int i = len - 3; i >= 0; --i) {
            for (int j = i + 2; j < len; ++j) {
                dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j];
            }
        }
        for (int i = 0; i < len - 2; ++i) {
            for (int j = i + 1; j < len - 1; ++j) {
                if (dp[0][i] && dp[i + 1][j] && dp[j + 1][len - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
};