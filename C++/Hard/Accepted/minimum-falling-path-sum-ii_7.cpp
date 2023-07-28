class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        
        int n = grid.size();
        if (n == 1)
            return grid[0][0];
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++)
            dp[0][i] = grid[0][i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minSum = INT_MAX;
                for (int k = 0; k < n; k++) {
                    if (k == j)
                        continue;
                    minSum = min(minSum, dp[i-1][k]);
                }
                dp[i][j] = minSum + grid[i][j];
            }
        }
        int minSum = INT_MAX;
        for (int i = 0; i < n; i++)
            minSum = min(minSum, dp[n-1][i]);
        return minSum;
    }
};