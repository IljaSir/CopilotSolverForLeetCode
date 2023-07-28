class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> grid1 = grid;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int i1 = (i + (j + k) / n) % m;
                int j1 = (j + k) % n;
                grid1[i1][j1] = grid[i][j];
            }
        }
        return grid1;
    }
};