class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int x = 0, y = 0, z = 0;
        for (int i = 0; i < n; i++) {
            int max_y = 0, max_z = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) x++;
                max_y = max(max_y, grid[i][j]);
                max_z = max(max_z, grid[j][i]);
            }
            y += max_y;
            z += max_z;
        }
        return x + y + z;
    }
};