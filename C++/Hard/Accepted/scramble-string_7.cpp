class Solution {
public:
    bool isScramble(string s1, string s2) {
        
        int n = s1.size();
        if (n != s2.size()) return false;
        if (n == 1) return s1 == s2;
        vector<vector<vector<bool>>> dp(n, vector<vector<bool>>(n, vector<bool>(n+1, false)));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j][1] = s1[i] == s2[j];
            }
        }
        for (int l = 2; l <= n; ++l) {
            for (int i = 0; i <= n-l; ++i) {
                for (int j = 0; j <= n-l; ++j) {
                    for (int k = 1; k < l; ++k) {
                        if ((dp[i][j][k] && dp[i+k][j+k][l-k]) || (dp[i][j+l-k][k] && dp[i+k][j][l-k])) {
                            dp[i][j][l] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
};