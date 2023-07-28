class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        int layer = 0, cnt = 0;
        while (m > 0 && n > 0) {
            cnt = 2 * (m + n) - 4;
            int c = k % cnt;
            for (int i = 0; i < c; ++i) {
                int tmp = grid[layer][layer];
                for (int j = layer; j < layer + n - 1; ++j)
                    grid[layer][j] = grid[layer][j + 1];
                for (int j = layer; j < layer + m - 1; ++j)
                    grid[j][layer + n - 1] = grid[j + 1][layer + n - 1];
                for (int j = layer + n - 1; j > layer; --j)
                    grid[layer + m - 1][j] = grid[layer + m - 1][j - 1];
                for (int j = layer + m - 1; j > layer; --j)
                    grid[j][layer] = grid[j - 1][layer];
                grid[layer + 1][layer] = tmp;
            }
            m -= 2;
            n -= 2;
            ++layer;
        }
        return grid;
    }
};