class Solution {
public:
    int minimumObstacles(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    if (grid[i][j] == 1) {
                        dp[i][j] = min(dp[i][j], dp[i - 1][j] + 1);
                    } else {
                        dp[i][j] = min(dp[i][j], dp[i - 1][j]);
                    }
                }
                if (j > 0) {
                    if (grid[i][j] == 1) {
                        dp[i][j] = min(dp[i][j], dp[i][j - 1] + 1);
                    } else {
                        dp[i][j] = min(dp[i][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
};