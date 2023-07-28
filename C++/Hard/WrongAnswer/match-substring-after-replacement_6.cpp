class Solution {
public:
    bool matchReplacement(string s, string sub, vector<vector<char>>& mappings) {
        
        int n = s.size(), m = sub.size();
        vector<vector<int>> mp(256, vector<int>(256, 0));
        for (auto& v : mappings) {
            mp[v[0]][v[1]] = 1;
        }
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s[i - 1] == sub[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (mp[s[i - 1]][sub[j - 1]]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (mp[sub[j - 1]][s[i - 1]]) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
};