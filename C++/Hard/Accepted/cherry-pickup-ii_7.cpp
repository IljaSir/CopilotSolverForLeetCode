class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(m, 0));
        for (int i = n - 1; i >= 0; i--) {
            vector<vector<int>> dp2(m, vector<int>(m, 0));
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    int val = grid[i][j];
                    if (j != k) val += grid[i][k];
                    int mx = 0;
                    for (int p = j - 1; p <= j + 1; p++) {
                        for (int q = k - 1; q <= k + 1; q++) {
                            if (p >= 0 && p < m && q >= 0 && q < m) {
                                mx = max(mx, dp[p][q]);
                            }
                        }
                    }
                    dp2[j][k] = mx + val;
                }
            }
            dp = dp2;
        }
        return dp[0][m - 1];
    }
};