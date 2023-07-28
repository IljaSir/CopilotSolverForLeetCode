class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    if (grid[x][y] > grid[i][j]) {
                        dp[i][j] += dp[x][y];
                        dp[i][j] %= mod;
                    }
                }
                if (i == 0 && j == 0) dp[i][j] = 1;
            }
        }
        return dp[m - 1][n - 1];
    }
};