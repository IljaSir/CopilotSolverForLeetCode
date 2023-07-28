class Solution {
public:
    int maxTrailingZeros(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int maxZeros = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                int zeros = 0;
                while (val % 10 == 0) {
                    zeros++;
                    val /= 10;
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + zeros;
                } else if (i > 0) {
                    dp[i][j] = dp[i-1][j] + zeros;
                } else if (j > 0) {
                    dp[i][j] = dp[i][j-1] + zeros;
                } else {
                    dp[i][j] = zeros;
                }
                maxZeros = max(maxZeros, dp[i][j]);
            }
        }
        return maxZeros;
    }
};