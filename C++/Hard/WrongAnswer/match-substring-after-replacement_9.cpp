class Solution {
public:
    bool matchReplacement(string s, string sub, vector<vector<char>>& mappings) {
        
        vector<vector<char>> m2;
        for (auto& v : mappings) {
            if (v[0] != v[1]) {
                m2.push_back(v);
            }
        }
        mappings = m2;
        int n = s.size();
        int m = sub.size();
        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (s[i - 1] == sub[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                for (auto& v : mappings) {
                    if (v[0] == sub[j - 1] && v[1] == s[i - 1]) {
                        dp[i][j] |= dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[n][m];
    }
};