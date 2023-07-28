class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        int numLayers = min(m, n) / 2;
        for (int layer = 0; layer < numLayers; layer++) {
            int numRotations = k % (2 * (m + n - 4 * layer) - 4);
            for (int i = 0; i < numRotations; i++) {
                int temp = grid[layer][layer];
                for (int j = layer; j < n - layer - 1; j++) {
                    grid[layer][j] = grid[layer][j + 1];
                }
                for (int j = layer; j < m - layer - 1; j++) {
                    grid[j][n - layer - 1] = grid[j + 1][n - layer - 1];
                }
                for (int j = n - layer - 1; j > layer; j--) {
                    grid[m - layer - 1][j] = grid[m - layer - 1][j - 1];
                }
                for (int j = m - layer - 1; j > layer + 1; j--) {
                    grid[j][layer] = grid[j - 1][layer];
                }
                grid[layer + 1][layer] = temp;
            }
        }
        return grid;
    }
};