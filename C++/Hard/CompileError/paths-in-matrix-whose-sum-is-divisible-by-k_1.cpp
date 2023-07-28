class Solution {
public:
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + grid[i][j];
            }
        }
        vector<vector<int>> dp2(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp2[i][j] = 1;
                }
                else if (i == 0) {
                    if (dp[i][j] % k == 0) {
                        dp2[i][j] = dp2[i][j - 1] + 1;
                    }
                    else {
                        dp2[i][j] = dp2[i][j - 1];
                    }
                }
                else if (j == 0) {
                    if (dp[i][j] % k == 0) {
                        dp2[i][j] = dp2[i - 1][j] + 1;
                    }
                    else {
                        dp2[i][j] = dp2[i - 1][j];
                    }
                }
                else {
                    if (dp[i][j] % k == 0) {
                        dp2[i][j] = dp2[i - 1][j] + dp2[i][j - 1] + 1;
                    }
                    else {
                        dp2[i][j] = dp2[i - 1][j] + dp
    }
};