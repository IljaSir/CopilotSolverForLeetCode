class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dp(n, vector<int>(n, INT_MIN));
        dp[0][0] = grid[0][0];
        for (int t = 1; t <= 2 * n - 2; t++) {
            vector<vector<int>> dp2(n, vector<int>(n, INT_MIN));
            for (int i = max(0, t - (n - 1)); i <= min(n - 1, t); i++) {
                for (int p = max(0, t - (n - 1)); p <= min(n - 1, t); p++) {
                    int j = t - i, q = t - p;
                    if (grid[i][j] == -1 || grid[p][q] == -1) {
                        continue;
                    }
                    int val = grid[i][j];
                    if (i != p) {
                        val += grid[p][q];
                    }
                    for (int pi = i - 1; pi <= i; pi++) {
                        for (int pj = p - 1; pj <= p; pj++) {
                            if (pi >= 0 && pj >= 0) {
                                dp2[i][p] = max(dp2[i][p], dp[pi][pj] + val);
                            }
                        }
                    }
                }
            }
            dp = dp2;
        }
        return max(0, dp[n - 1][n - 1]);
    }
};