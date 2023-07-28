class Solution {
public:
    int maxTrailingZeros(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int up = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                    int tmp = grid[i][j];
                    while (tmp % 5 == 0) {
                        tmp /= 5;
                        ++up;
                    }
                }
                int left = 0;
                if (j > 0) {
                    left = dp[i][j - 1];
                    int tmp = grid[i][j];
                    while (tmp % 5 == 0) {
                        tmp /= 5;
                        ++left;
                    }
                }
                dp[i][j] = max(up, left);
            }
        }
        return dp[m - 1][n - 1];
    }
};