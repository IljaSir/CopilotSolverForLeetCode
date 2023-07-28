class Solution {
public:
    int appendCharacters(string s, string t) {
        
        int n = s.size(), m = t.size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (s[i - 1] == t[j - 1]) {
                        dp[i][j] |= dp[i - 1][j - 1];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = n; i >= 0; --i) {
            if (dp[i][m] == 1) {
                ans = n - i;
                break;
            }
        }
        return ans;
    }
};