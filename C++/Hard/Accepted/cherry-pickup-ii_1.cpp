class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = m - 1; i >= 0; --i) {
            vector<vector<int>> dp2(n, vector<int>(n, 0));
            for (int j = 0; j < n; ++j) {
                for (int k = j; k < n; ++k) {
                    for (int j2 = j - 1; j2 <= j + 1; ++j2) {
                        for (int k2 = k - 1; k2 <= k + 1; ++k2) {
                            if (j2 >= 0 && k2 >= 0 && j2 < n && k2 < n) {
                                dp2[j][k] = max(dp2[j][k], dp[j2][k2]);
                            }
                        }
                    }
                    dp2[j][k] += grid[i][j];
                    if (j != k) dp2[j][k] += grid[i][k];
                }
            }
            dp = dp2;
        }
        return dp[0][n - 1];
    }
};