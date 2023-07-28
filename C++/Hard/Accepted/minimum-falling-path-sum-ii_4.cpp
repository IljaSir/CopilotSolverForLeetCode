class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int ans = INT_MAX;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int minval = INT_MAX;
                for (int k = 0; k < n; ++k) {
                    if (k == j) continue;
                    minval = min(minval, grid[i - 1][k]);
                }
                grid[i][j] += minval;
            }
        }
        for (int j = 0; j < n; ++j) {
            ans = min(ans, grid[n - 1][j]);
        }
        return ans;
    }
};