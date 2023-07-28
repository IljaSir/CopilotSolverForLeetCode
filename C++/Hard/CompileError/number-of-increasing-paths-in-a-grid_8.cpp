class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int mod = 1e9 + 7;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (auto& dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > grid[i][j]) {
                        dp[i][j] = (dp[i][j] + dp[x][y]) % mod;
                    }
                }
                if (i == 0 && j == 0) dp[i][j] = 1;
            }
        }
        return dp[m - 1][n - 1];
    }
    int countPaths(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        int mod = 1e9 + 7;
        vector<vector<int>> dp(m, vector<int>(n, 0));
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (auto& dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > grid[i][j]) {
                        dp[i][j] = (dp[i][j] + dp[x][y]) % mod;
                    }
                }
                if (i == 0 && j == 0) dp[i][j] = 1;
            }
        }
        return dp[m - 1][n - 1];
    }
};