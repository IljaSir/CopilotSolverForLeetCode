class Solution {
public:
    int numWays(vector<string>& words, string target) {
        
        int n = words.size(), m = words[0].size(), t = target.size();
        vector<vector<int>> cnt(m, vector<int>(26));
        for (auto &w : words) {
            for (int i = 0; i < m; ++i) {
                ++cnt[i][w[i] - 'a'];
            }
        }
        vector<vector<int>> dp(t + 1, vector<int>(m));
        for (int i = 0; i < m; ++i) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < t; ++i) {
            for (int j = i; j < m; ++j) {
                int c = target[i] - 'a';
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j] * cnt[j][c];
                dp[i + 1][j + 1] %= 1000000007;
            }
        }
        return dp[t][m];
    }
};