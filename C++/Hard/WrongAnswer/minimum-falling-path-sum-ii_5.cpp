class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j];
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                    if (j > 0) {
                        dp[i][j] = min(dp[i][j], dp[i - 1][j - 1] + grid[i][j]);
                    }
                    if (j < n - 1) {
                        dp[i][j] = min(dp[i][j], dp[i - 1][j + 1] + grid[i][j]);
                    }
                    if (i == n - 1) {
                        if (j == 0) {
                            dp[i][j] = min(dp[i][j], dp[i][j + 1]);
                        } else if (j == n - 1) {
                            dp[i][j] = min(dp[i][j], dp[i][j - 1]);
                        } else {
                            dp[i][j] = min(dp[i][j], min(dp[i][j - 1], dp[i][j + 1]));
                        }
                    }
                }
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            ans = min(ans, dp[n - 1][i]);
        }
        return ans;
    }
};