class Solution {
public:
    bool checkPartitioning(string s) {
        
        int n = s.size();
        vector<vector<bool>> dp(n, vector<bool>(n,false));
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = (s[i] == s[i + 1]);
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                [i]]= dp[i ][j - 1] && (s[i] == s[j]);
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[0][i - 1] && dp[i][j - 1] && dp[j
            for (int j = i + 1; j < n; ++j) {
                if (dp[0][i - 1] && dp[i][j - 1] && dp[j][n - 1]) return true;
            }
        }
        return false;
    }
};