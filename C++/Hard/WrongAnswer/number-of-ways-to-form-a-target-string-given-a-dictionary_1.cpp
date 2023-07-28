class Solution {
public:
    int numWays(vector<string>& words, string target) {
        
        int n = words.size(), m = words[0].size(), t = target.size();
        vector<vector<int>> cnt(m, vector<int>(26));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ++cnt[j][words[i][j] - 'a'];
            }
        }
        vector<vector<int>> dp(t + 1, vector<int>(m));
        for (int i = 0; i < m; ++i) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < t; ++i) {
            for (int j = i; j < m; ++j) {
                if (j > i) {
                    dp[i + 1][j] = dp[i + 1][j - 1];
                }
                dp[i + 1][j] = (dp[i + 1][j] + 1ll * dp[i][j] * cnt[j][target[i] - 'a']) % 1000000007;
            }
        }
        return dp[t][m - 1];
    }
};