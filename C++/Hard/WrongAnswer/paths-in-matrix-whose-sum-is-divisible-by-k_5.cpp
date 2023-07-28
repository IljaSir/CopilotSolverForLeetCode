class Solution {
public:
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; ++j) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int p = i; p < m; ++p) {
                    for (int q = j; q < n; ++q) {
                        int sum = dp[p][q];
                        if (i > 0) {
                            sum -= dp[i - 1][q];
                        }
                        if (j > 0) {
                            sum -= dp[p][j - 1];
                        }
                        if (i > 0 && j > 0) {
                            sum += dp[i - 1][j - 1];
                        }
                        if (sum % k == 0) {
                            ++ans;
                        }
                    }
                }
            }
        }
        return ans;
    }
};