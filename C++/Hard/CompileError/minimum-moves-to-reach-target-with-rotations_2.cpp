class Solution {
public:
    int minimumMoves(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>(2, INT_MAX)));
        dp[0][0][0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                    dp[i][j][0] = min(dp[i][j][0], dp[i - 1][j][0]);
                    dp[i][j][1] = min(dp[i][j][1], dp[i - 1][j][1]);
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                    dp[i][j][0] = min(dp[i][j][0], dp[i][j - 1][0]);
                    dp[i][j][1] = min(dp[i][j][1], dp[i][j - 1][1]);
                }
                if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j] == 0 && grid[i][j - 1] == 0 && grid[i - 1][j - 1] == 0) {
                    dp[i][j][0] = min(dp[i][j][0], dp[i - 1][j - 1][1]);
                    dp[i][j][1] = min(dp[i][j][1], dp[i - 1][j - 1][0]);
                }
                if (grid[i][j] == 0) {
                    if (i + 1 < n && grid[i + 1][j] == 0) {
                        dp[i + 1][j][0] = min(dp[i + 1][j][0], dp[i][j][0] + 1);
                        dp[i + 1][j][1] = min(dp[i + 1][j][1], dp[i][j][1] + 1);
                    }
                    if (j + 1 < n && grid[i][j + 1] == 0) {
                        dp[i][j + 1][0] =
    }
};