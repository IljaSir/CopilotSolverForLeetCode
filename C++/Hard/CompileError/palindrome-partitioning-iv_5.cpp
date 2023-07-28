class Solution {
public:
    bool checkPartitioning(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
            if (i + 1 < n) {
                dp[i][i + 1] = s[i] == s[i + 1];
            }
        }
        for (int len = 3; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j];
            }
        } - 1];
            }
        }
        for (int i = 1; i < n - 1; ++i) { dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
};