class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>(2, INT_MAX)));
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][0][1] = 1;
        dp[0][1][1] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < n && grid[i][j] == 0 && grid[i+1][j] == 0) {
                    dp[i+1][j][0] = min(dp[i+1][j][0], dp[i][j][0] + 1);
                    dp[i+1][j][0] = min(dp[i+1][j][0], dp[i][j][1] + 1);
                    dp[i][j+1][1] = min(dp[i][j+1][1], dp[i][j][0] + 1);
                    dp[i][j+1][1] = min(dp[i][j+1][1], dp[i][j][1] + 1);
                }
                if (j + 1 < n && grid[i][j] == 0 && grid[i][j+1] == 0) {
                    dp[i][j+1][1] = min(dp[i][j+1][1], dp[i][j][1] + 1);
                    dp[i][j+1][1] = min(dp[i][j+1][1], dp[i][j][0] + 1);
                    dp[i+1][j][0] = min(dp[i+1][j][0], dp[i][j][0] + 1);
                    dp[i+1][j][0] = min(dp[i+1][j][0], dp[i][j][1] + 1);
                }
            }
        }
        return min(dp[n-1][n-1][0], dp[n-1][n-1][1]) == INT_MAX ? -1 : min(dp[n-1][n-1][0], dp[n-1][n-1][1]);
    }
};