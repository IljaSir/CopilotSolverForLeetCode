class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = m - 1; i >= 0; i--) {
            vector<vector<int>> t(n, vector<int>(n, 0));
            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {
                    int cur = 0;
                    cur = max(cur, dp[j][k]);
                    if (j > 0) cur = max(cur, dp[j - 1][k]);
                    if (k < n - 1) cur = max(cur, dp[j][k + 1]);
                    if (j > 0 && k < n - 1) cur = max(cur, dp[j - 1][k + 1]);
                    t[j][k] = cur + grid[i][j] + (j == k ? 0 : grid[i][k]);
                }
            }
            dp = t;
        }
        return dp[0][n - 1];
    }
};