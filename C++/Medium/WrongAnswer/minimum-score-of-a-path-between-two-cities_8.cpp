class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> dp(n+1, vector<int>(n+1, INT_MAX));
        for (auto &r: roads) {
            dp[r[0]][r[1]] = min(dp[r[0]][r[1]], r[2]);
            dp[r[1]][r[0]] = min(dp[r[1]][r[0]], r[2]);
        }
        for (int i = 1; i <= n; ++i) dp[i][i] = 0;
        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    dp[i][j] = min(dp[i][j], max(dp[i][k], dp[k][j]));
                }
            }
        }
        return dp[1][n];
    }
};