class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(n, -1)));
        dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (dp[i - 1][j][k] < 0) continue;
                    for (int d1 = -1; d1 <= 1; ++d1) {
                        for (int d2 = -1; d2 <= 1; ++d2) {
                            int j1 = j + d1;
                            int k1 = k + d2;
                            if (j1 < 0 || j1 >= n || k1 < 0 || k1 >= n) continue;
                            int cur = dp[i - 1][j][k] + grid[i][j1];
                            if (j1 != k1) cur += grid[i][k1];
                            dp[i][j1][k1] = max(dp[i][j1][k1], cur);
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int j = 0; j < n; ++j) {
            for (int k = 0; k < n; ++k) {
                res = max(res, dp[m - 1][j][k]);
            }
        }
        return res;
    }
};