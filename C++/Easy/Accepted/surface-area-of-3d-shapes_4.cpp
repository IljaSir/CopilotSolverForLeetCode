class Solution {
public:
    int surfaceArea(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    res += 2;
                    if (i == 0) res += grid[i][j];
                    if (i == n - 1) res += grid[i][j];
                    if (j == 0) res += grid[i][j];
                    if (j == n - 1) res += grid[i][j];
                    if (i > 0) res += max(grid[i][j] - grid[i - 1][j], 0);
                    if (i < n - 1) res += max(grid[i][j] - grid[i + 1][j], 0);
                    if (j > 0) res += max(grid[i][j] - grid[i][j - 1], 0);
                    if (j < n - 1) res += max(grid[i][j] - grid[i][j + 1], 0);
                }
            }
        }
        return res;
    }
};