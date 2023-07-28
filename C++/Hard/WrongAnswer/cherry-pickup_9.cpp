class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        dp[0][0] = grid[0][0];
        for (int t = 1; t < 2 * n - 1; ++t) {
            vector<vector<int>> dp2(n, vector<int>(n, 0));
            for (int i = max(0, t - n + 1); i <= min(n - 1, t); ++i) {
                for (int p = max(0, t - n + 1); p <= min(n - 1, t); ++p) {
                    int j = t - i, q = t - p;
                    if (grid[i][j] == -1 || grid[p][q] == -1) {
                        dp2[i][p] = -1;
                        continue;
                    }
                    if (i > 0) dp2[i][p] = max(dp2[i][p], dp[i - 1][p]);
                    if (p > 0) dp2[i][p] = max(dp2[i][p], dp[i][p - 1]);
                    if (i > 0 && p > 0) dp2[i][p] = max(dp2[i][p], dp[i - 1][p - 1]);
                    if (dp2[i][p] >= 0) dp2[i][p] += grid[i][j];
                    if (i != p) dp2[i][p] += grid[p][q];
                }
            }
            dp = dp2;
        }
        return max(dp[n - 1][n - 1], 0);
    }
};