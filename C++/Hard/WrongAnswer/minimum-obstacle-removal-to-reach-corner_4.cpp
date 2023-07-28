class Solution {
public:
    int minimumObstacles(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int dp[m][n];
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] == 1 ? dp[i-1][0] + 1 : dp[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] == 1 ? dp[0][i-1] + 1 : dp[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + 1;
                } else {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
};