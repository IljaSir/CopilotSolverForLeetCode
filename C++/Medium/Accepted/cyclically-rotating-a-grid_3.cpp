class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        int layers = min(m, n) / 2;
        for (int i = 0; i < layers; ++i) {
            int layerSize = 2 * (m - 2 * i + n - 2 * i) - 4;
            int k2 = k % layerSize;
            if (k2 == 0) continue;
            vector<int> layer(layerSize);
            int idx = 0;
            for (int j = i; j < n - i; ++j) layer[idx++] = grid[i][j];
            for (int j = i + 1; j < m - i; ++j) layer[idx++] = grid[j][n - i - 1];
            for (int j = n - i - 2; j >= i; --j) layer[idx++] = grid[m - i - 1][j];
            for (int j = m - i - 2; j > i; --j) layer[idx++] = grid[j][i];
            rotate(layer.begin(), layer.begin() + k2, layer.end());
            idx = 0;
            for (int j = i; j < n - i; ++j) grid[i][j] = layer[idx++];
            for (int j = i + 1; j < m - i; ++j) grid[j][n - i - 1] = layer[idx++];
            for (int j = n - i - 2; j >= i; --j) grid[m - i - 1][j] = layer[idx++];
            for (int j = m - i - 2; j > i; --j) grid[j][i] = layer[idx++];
        }
        return grid;
    }
};