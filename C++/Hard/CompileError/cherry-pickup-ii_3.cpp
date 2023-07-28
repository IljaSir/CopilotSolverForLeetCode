class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int rows = grid.size();
        int cols = grid[0].size();
        vector<vector<vector<int>>> dp(rows, vector<vector<int>>(cols, vector<int>(cols, -1)));
        dp[0][0][cols - 1] = grid[0][0] + grid[0][cols - 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    if (dp[i][j][k] == -1) {
                        continue;
                    }
                    if (j + 1 < cols) {
                        dp[i][j + 1][k] = max(dp[i][j + 1][k], dp[i][j][k] + grid[i][j + 1]);
                    }
                    if (k - 1 >= 0) {
                        dp[i][j][k - 1] = max(dp[i][j][k - 1], dp[i][j][k] + grid[i][k - 1]);
                    }
                    if (j + 1 < cols && k - 1 >= 0) {
                        dp[i][j + 1][k - 1] = max(dp[i][j + 1][k - 1], dp[i][j][k] + grid[i][j + 1] + grid[i][k - 1]);
                    }
                    if (i + 1 < rows) {
                        dp[i + 1][j][k] = max(dp[i + 1][j][k], dp[i][j][k] + grid[i + 1][j] + grid[i + 1][k]);
                    }
                    if (j + 1 < cols && i + 1 < rows) {
                        dp[i + 1][j + 1][k] = max(dp[i + 1][j + 1][k], dp[i][j][k] + grid[i + 1][j + 1] + grid[i + 1][k]);
                    }
                    if (k - 1 >= 0 && i + 1 < rows) {
                        dp[i + 1][j][k - 1] = max(dp[i + 1][j][k
    }
};