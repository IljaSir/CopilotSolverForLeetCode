class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>(n, -1)));
        dp[0][0][0] = grid[0][0];
        for (int t = 1; t <= 2 * n - 2; ++t) {
            for (int i = max(0, t - (n - 1)); i <= min(n - 1, t); ++i) {
                for (int j = max(0, t - (n - 1)); j <= min(n - 1, t); ++j) {
                    if (grid[i][t - i] == -1 || grid[j][t - j] == -1) {
                        dp[i][j][t] = -1;
                        continue;
                    }
                    int val = grid[i][t - i];
                    if (i != j) {
                        val += grid[j][t - j];
                    }
                    for (int pi = i - 1; pi <= i; ++pi) {
                        for (int pj = j - 1; pj <= j; ++pj) {
                            if (pi >= 0 && pj >= 0 && dp[pi][pj][t - 1] >= 0) {
                                dp[i][j][t] = max(dp[i][j][t], dp[pi][pj][t - 1] + val);
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int t = 0; t <= 2 * n - 2; ++t) {
            ans = max(ans, dp[n - 1][n - 1][t]);
        }
        return max(ans, 0);
    }
};