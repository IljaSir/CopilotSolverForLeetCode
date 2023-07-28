class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        vector<vector<int>> dirs{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int mod = 1e9 + 7;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (auto& dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[i][j] < grid[x][y]) {
                        dp[i][j] = (dp[i][j] + dp[x][y]) % mod;
                    }
                }
                dp[i][j] += (grid[i][j] == 1 ? 1 : 0);
            }
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = (res + dp[i][j]) % mod;
            }
        }
        return res;
    }
};