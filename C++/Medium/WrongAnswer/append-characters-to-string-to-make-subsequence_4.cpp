class Solution {
public:
    int appendCharacters(string s, string t) {
        
        int n = s.size(), m = t.size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            if (dp[i][m] == m) {
                res = n - i;
                break;
            }
        }
        return res;
    }
};