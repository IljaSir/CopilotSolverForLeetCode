class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        int layer = min(m, n) / 2;
        for (int l = 0; l < layer; ++l) {
            int len = (m - l * 2 + n - l * 2) * 2 - 4;
            int kk = k % len;
            for (int i = 0; i < kk; ++i) {
                int x = l;
                int y = l;
                int tmp = grid[x][y];
                int tmp2;
                while (y < n - l - 1) {
                    tmp2 = grid[x][y + 1];
                    grid[x][y + 1] = tmp;
                    tmp = tmp2;
                    ++y;
                }
                while (x < m - l - 1) {
                    tmp2 = grid[x + 1][y];
                    grid[x + 1][y] = tmp;
                    tmp = tmp2;
                    ++x;
                }
                while (y > l) {
                    tmp2 = grid[x][y - 1];
                    grid[x][y - 1] = tmp;
                    tmp = tmp2;
                    --y;
                }
                while (x > l) {
                    tmp2 = grid[x - 1][y];
                    grid[x - 1][y] = tmp;
                    tmp = tmp2;
                    --x;
                }
            }
        }
        return grid;
    }
};