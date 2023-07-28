class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        int i = 0;
        while (i < m / 2 && i < n / 2) {
            int len = 2 * (m - 2 * i) + 2 * (n - 2 * i) - 4;
            int l = k % len;
            for (int j = 0; j < l; ++j) {
                int t = grid[i][i];
                for (int x = i + 1; x < n - i; ++x) {
                    grid[i][x - 1] = grid[i][x];
                }
                for (int y = i + 1; y < m - i; ++y) {
                    grid[y - 1][n - i - 1] = grid[y][n - i - 1];
                }
                for (int x = n - i - 2; x >= i; --x) {
                    grid[m - i - 1][x + 1] = grid[m - i - 1][x];
                }
                for (int y = m - i - 2; y > i; --y) {
                    grid[y + 1][i] = grid[y][i];
                }
                grid[i + 1][i] = t;
            }
            ++i;
        }
        return grid;
    }
};