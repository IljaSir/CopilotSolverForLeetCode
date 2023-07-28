class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (i > 0 && grid[i - 1][j] < val) {
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] %= 1000000007;
                }
                if (j > 0 && grid[i][j - 1] < val) {
                    dp[i][j] += dp[i][j - 1];
                    dp[i][j] %= 1000000007;
                }
                if (i < m - 1 && grid[i + 1][j] < val) {
                    dp[i][j] += dp[i + 1][j];
                    dp[i][j] %= 1000000007;
                }
                if (j < n - 1 && grid[i][j + 1] < val) {
                    dp[i][j] += dp[i][j + 1];
                    dp[i][j] %= 1000000007;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
};