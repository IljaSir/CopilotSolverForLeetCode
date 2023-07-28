class Solution {
public:
    int cherryPickup(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        dp[0][n-1] = grid[0][0] + grid[0][n-1];
        for (int i = 1; i < m; i++) {
            vector<vector<int>> tmp(n, vector<int>(n, 0));
            for (int j = 0; j < n; j++) {
                for (int k = j; k < n; k++) {
                    if (grid[i][j] == -1 || grid[i][k] == -1) continue;
                    int cur = max(dp[j][k], max(dp[j][k-1], max(dp[j][k+1], max(dp[j-1][k], max(dp[j-1][k-1], max(dp[j-1][k+1], max(dp[j+1][k], max(dp[j+1][k-1], dp[j+1][k+1]))))))));
                    tmp[j][k] = cur + grid[i][j] + grid[i][k] - (j == k ? grid[i][j] : 0);
                }
            }
            dp = tmp;
        }
        return dp[0][n-1];
    }
};