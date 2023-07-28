class Solution {
public:
    int minimumObstacles(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 1e9));
        dp[0][0] = grid[0][0] == 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] = min(dp[i][j], dp[i - 1][j] + (grid[i][j] == 1));
                }
                if (j > 0) {
                    dp[i][j] = min(dp[i][j], dp[i][j - 1] + (grid[i][j] == 1));
                }
            }
        }
        return dp[m - 1][n - 1];
    }
};