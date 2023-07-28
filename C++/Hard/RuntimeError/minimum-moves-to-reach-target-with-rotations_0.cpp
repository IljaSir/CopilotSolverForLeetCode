class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>(2, INT_MAX)));
        dp[0][0][0] = 0;
        dp[0][1][1] = 0;
        int res = INT_MAX;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    dp[i][j][0] = dp[i][j][1] = INT_MAX;
                }
                if (i > 0) {
                    dp[i][j][0] = min(dp[i][j][0], dp[i - 1][j][0] + 1);
                    dp[i][j][1] = min(dp[i][j][1], dp[i - 1][j][1] + 1);
                }
                if (j > 0) {
                    dp[i][j][0] = min(dp[i][j][0], dp[i][j - 1][0] + 1);
                    dp[i][j][1] = min(dp[i][j][1], dp[i][j - 1][1] + 1);
                }
                if (i > 0 && j > 0) {
                    if (grid[i - 1][j] == 0 && grid[i][j - 1] == 0) {
                        dp[i][j][0] = min(dp[i][j][0], dp[i - 1][j - 1][1] + 1);
                        dp[i][j][1] = min(dp[i][j][1], dp[i - 1][j - 1][0] + 1);
                    }
                }
                if (i == n - 1 && j == n - 2) {
                    res = min(res, dp[i][j][0]);
                }
                if (i == n - 2 && j == n - 1) {
                    res = min(res, dp[i][j][1]);
                }
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};