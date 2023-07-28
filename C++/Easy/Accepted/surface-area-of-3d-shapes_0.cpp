class Solution {
public:
    int surfaceArea(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) ans += 2;
                ans += max(0, grid[i][j] - (i > 0 ? grid[i - 1][j] : 0));
                ans += max(0, grid[i][j] - (i < n - 1 ? grid[i + 1][j] : 0));
                ans += max(0, grid[i][j] - (j > 0 ? grid[i][j - 1] : 0));
                ans += max(0, grid[i][j] - (j < n - 1 ? grid[i][j + 1] : 0));
            }
        }
        return ans;
    }
};