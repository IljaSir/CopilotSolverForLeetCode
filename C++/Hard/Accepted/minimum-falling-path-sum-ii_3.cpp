class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int ans = INT_MAX;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int minPath = INT_MAX;
                for (int k = 0; k < n; ++k) {
                    if (k == j) continue;
                    minPath = min(minPath, grid[i - 1][k]);
                }
                grid[i][j] += minPath;
            }
        }
        for (int i = 0; i < n; ++i) {
            ans = min(ans, grid[n - 1][i]);
        }
        return ans;
    }
};