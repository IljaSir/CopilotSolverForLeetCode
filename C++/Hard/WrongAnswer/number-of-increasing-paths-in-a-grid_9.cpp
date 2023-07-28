class Solution {
public:
    int countPaths(vector<vector<int>>& grid) {
        
        const int MOD = 1e9+7;
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        vector<vector<int>> dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i=0; i<m; ++i) {
            for (int j=0; j<n; ++j) {
                for (auto& d : dir) {
                    int x = i + d[0], y = j + d[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] >= grid[i][j]) {
                        continue;
                    }
                    dp[i][j] = (dp[i][j] + dp[x][y]) % MOD;
                }
                if (dp[i][j] == 0) {
                    dp[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i=0; i<m; ++i) {
            for (int j=0; j<n; ++j) {
                ans = (ans + dp[i][j]) % MOD;
            }
        }
        return ans;
    }
};