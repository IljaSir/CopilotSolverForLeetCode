class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dp(n, vector<int>(n, n*n));
        dp[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i + 1 < n && grid[i][j] == 0 && grid[i+1][j] == 0) {
                    dp[i+1][j] = min(dp[i+1][j], dp[i][j] + 1);
                    if (j + 1 < n && grid[i+1][j+1] == 0) {
                        dp[i+1][j+1] = min(dp[i+1][j+1], dp[i][j] + 1);
                        if (i - 1 >= 0 && grid[i-1][j] == 0) {
                            dp[i][j+1] = min(dp[i][j+1], dp[i][j] + 1);
                        }
                    }
                }
                if (j + 1 < n && grid[i][j] == 0 && grid[i][j+1] == 0) {
                    dp[i][j+1] = min(dp[i][j+1], dp[i][j] + 1);
                    if (i + 1 < n && grid[i+1][j+1] == 0) {
                        dp[i+1][j+1] = min(dp[i+1][j+1], dp[i][j] + 1);
                        if (j - 1 >= 0 && grid[i][j-1] == 0) {
                            dp[i+1][j] = min(dp[i+1][j], dp[i][j] + 1);
                        }
                    }
                }
            }
        }
        return dp[n-1][n-1] == n*n ? -1 : dp[n-1][n-1];
    }
};