class Solution {
public:
    int minPathCost(vector<vector<int>>& grid, vector<vector<int>>& moveCost) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n));
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            vector<int> minCost(n, INT_MAX);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    minCost[j] = min(minCost[j], dp[i - 1][k] + moveCost[grid[i - 1][k] * n + k][j]);
                }
            }
            for (int j = 0; j < n; j++) {
                dp[i][j] = minCost[j] + grid[i][j];
            }
        }
        return *min_element(dp[m - 1].begin(), dp[m - 1].end());
    }
};