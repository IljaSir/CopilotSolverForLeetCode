class Solution {
public:
    int minPathCost(vector<vector<int>>& grid, vector<vector<int>>& moveCost) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, INT_MAX));
        for (int j = 0; j < n; ++j) {]);
        return *min_element(dp[m - 1].begin(), dp[m - 1].end());
    }
};