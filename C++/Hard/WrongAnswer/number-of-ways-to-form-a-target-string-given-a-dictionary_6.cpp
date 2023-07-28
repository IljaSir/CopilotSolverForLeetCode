class Solution {
public:
    int numWays(vector<string>& words, string target) {
        
        int n = words.size(), m = words[0].size(), t = target.size();
        vector<vector<int>> cnt(m, vector<int>(26));
        for (string &w : words) {
            for (int i = 0; i < m; ++i) {
                ++cnt[i][w[i] - 'a'];
            }
        }
        vector<vector<int>> dp(t + 1, vector<int>(m + 1));
        dp[0][0] = 1;
        for (int i = 1; i <= t; ++i) {
            for (int j = i; j <= m; ++j) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1] * cnt[j - 1][target[i - 1] - 'a'];
                dp[i][j] %= 1000000007;
            }
        }
        return dp[t][m];
    }
};