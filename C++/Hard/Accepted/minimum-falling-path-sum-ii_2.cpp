class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> dp = grid;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = INT_MAX;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    dp[i][j] = min(dp[i][j], dp[i - 1][k] + grid[i][j]);
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