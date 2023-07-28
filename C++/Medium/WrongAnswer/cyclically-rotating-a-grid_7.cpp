class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        int x = 0, y = 0;
        while (m > 1 && n > 1) {
            int t = k % (2 * m + 2 * n - 4);
            while (t--) {
                int tmp = grid[x][y];
                for (int i = x; i < x + m - 1; ++i) grid[i][y] = grid[i + 1][y];
                for (int i = y; i < y + n - 1; ++i) grid[x + m - 1][i] = grid[x + m - 1][i + 1];
                for (int i = x + m - 1; i > x; --i) grid[i][y + n - 1] = grid[i - 1][y + n - 1];
                for (int i = y + n - 1; i > y; --i) grid[x][i] = grid[x][i - 1];
                grid[x][y + 1] = tmp;
            }
            ++x, ++y;
            m -= 2;
            n -= 2;
        }
        return grid;
    }
};