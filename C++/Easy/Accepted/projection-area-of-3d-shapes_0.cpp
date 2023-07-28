class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int bestRow = 0;  // largest of grid[i][j]
            int bestCol = 0;  // largest of grid[j][i]
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) ans++;  // top shadow
                bestRow = max(bestRow, grid[i][j]);
                bestCol = max(bestCol, grid[j][i]);
            }
            ans += bestRow + bestCol;
        }
        return ans;
    }
};