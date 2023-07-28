class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dp(n, vector<int>(n, -1));
        dp[0][0] = grid[0][0];
        for (int k = 1; k < 2 * n - 1; ++k) {
            vector<vector<int>> dp2(n, vector<int>(n, -1));
            for (int i = max(0, k - n + 1); i <= min(n - 1, k); ++i) {
                for (int p = max(0, k - n + 1); p <= min(n - 1, k); ++p) {
                    int j = k - i, q = k - p;
                    if (grid[i][j] == -1 || grid[p][q] == -1) {
                        continue;
                    }
                    int val = grid[i][j];
                    if (i != p) {
                        val += grid[p][q];
                    }
                    for (int di = -1; di <= 0; ++di) {
                        for (int dp = -1; dp <= 0; ++dp) {
                            if (i + di >= 0 && p + dp >= 0) {
                                dp2[i][p] = max(dp2[i][p], dp[i + di][p + dp] + val);
                            }
                        }
                    }
                }
            }
            dp = dp2;
        }
        return max(dp[n - 1][n - 1], 0);
    }
};