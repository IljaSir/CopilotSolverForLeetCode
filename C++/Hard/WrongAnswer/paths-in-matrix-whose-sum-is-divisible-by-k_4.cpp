class Solution {
public:
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[0][0] = grid[0][0] % k;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (dp[i - 1][0] + grid[i][0]) % k;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = (dp[0][j - 1] + grid[0][j]) % k;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + grid[i][j]) % k;
            }
        }
        return dp[m - 1][n - 1];
    }
    int paths(vector<vector<int>>& grid, int k) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[0][0] = grid[0][0] % k == 0 ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + (grid[i][0] % k == 0 ? 1 : 0);
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + (grid[0][j] % k == 0 ? 1 : 0);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + (grid[i][j] % k == 0 ? 1 : 0);
            }
        }
        return dp[m - 1][n - 1];
    }
};