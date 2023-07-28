class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int res = INT_MAX;
        vector<vector<int>> dp(n, vector<int>(n, INT_MAX));
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    dp[i][j] = min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res = min(res, dp[n - 1][i]);
        }
        return res;
    }
};