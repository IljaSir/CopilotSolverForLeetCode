class Solution {
public:
    int maxTrailingZeros(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i == m - 1 && j == n - 1) {
                    int cnt = 0;
                    while (grid[i][j] % 10 == 0) {
                        grid[i][j] /= 10;
                        ++cnt;
                    }
                    dp[i][j] = cnt;
                } else if (i == m - 1) {
                    int cnt = 0;
                    while (grid[i][j] % 10 == 0) {
                        grid[i][j] /= 10;
                        ++cnt;
                    }
                    dp[i][j] = min(dp[i][j + 1], cnt);
                } else if (j == n - 1) {
                    int cnt = 0;
                    while (grid[i][j] % 10 == 0) {
                        grid[i][j] /= 10;
                        ++cnt;
                    }
                    dp[i][j] = min(dp[i + 1][j], cnt);
                } else {
                    int cnt = 0;
                    while (grid[i][j] % 10 == 0) {
                        grid[i][j] /= 10;
                        ++cnt;
                    }
                    dp[i][j] = min(min(dp[i + 1][j], dp[i][j + 1]), cnt);
                }
            }
        }
        return dp[0][0];
    }
};