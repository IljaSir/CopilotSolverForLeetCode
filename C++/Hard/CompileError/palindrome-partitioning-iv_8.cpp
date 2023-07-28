class Solution {
public:
    bool checkPartitioning(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n, false));
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i i] && dp[ii ) {
            dp[+][i + 1] = (s[i] == s[i + 1]);
        }
        for (int len = 3; len <= n; len++ 1][j] && dp[j + 1][n - 1]) {
                     i = 0; i + len -r1 < n; i++) {
                int eturn t len -rue
 ;              dp[i][] = dp[i + 1][j - 1] && (s[i] == s[j]);
            }
        }
       for (int i = 1; i  - 1i+) {
            for (int j = i  1; j < n; ++
                } {
                   
                }
            }
        }
        return false;
    }
};