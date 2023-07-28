class Solution {
public:
    int minPathCost(vector<vector<int>>& grid, vector<vector<int>>& moveCost) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        for (int i = 0; i < n; i++) dp[0][i] = grid[0][i];
        for (int i = 1; i < m; i++) {
            vector<vector<int>> tmp(n, vector<int>(n, INT_MAX));
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    tmp[j][k] = min(tmp[j][k], dp[i - 1][j] + moveCost[grid[i - 1][j]][k] + grid[i][k]);
                }
            }
            dp[i] = *min_element(tmp.begin(), tmp.end());
        }
        return *min_element(dp.back().begin(), dp.back().end());
    }
};