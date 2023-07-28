class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int dp[n][m][m];
        memset(dp, 0, sizeof(dp));
        dp[0][0][m-1] = grid[0][0] + grid[0][m-1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (j > k) continue;
                    int maxVal = 0;
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            int nj = j + x;
                            int nk = k + y;
                            if (nj >= 0 && nj < m && nk >= 0 && nk < m) {
                                maxVal = max(maxVal, dp[i-1][nj][nk]);
                            }
                        }
                    }
                    dp[i][j][k] = maxVal + (j == k ? grid[i][j] : grid[i][j] + grid[i][k]);
                }
            }
        }
        return dp[n-1][m-1][0];
    }
};