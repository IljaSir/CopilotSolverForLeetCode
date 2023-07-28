class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> grid2(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = (j + k) % n;
                int y = (i + (j + k) / n) % m;
                grid2[y][x] = grid[i][j];
            }
        }
        return grid2;
    }
};