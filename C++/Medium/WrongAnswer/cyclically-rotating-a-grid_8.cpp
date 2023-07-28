class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size(), n = grid[0].size();
        int i = 0, j = 0;
        while (i < m && j < n) {
            int len = (m - i) * 2 + (n - j) * 2 - 4;
            int K = k % len;
            while (K--) {
                int tmp = grid[i][j];
                for (int x = j; x < n - j - 1; ++x) {
                    grid[i][x] = grid[i][x + 1];
                }
                for (int y = i; y < m - i - 1; ++y) {
                    grid[y][n - j - 1] = grid[y + 1][n - j - 1];
                }
                for (int x = n - j - 1; x > j; --x) {
                    grid[m - i - 1][x] = grid[m - i - 1][x - 1];
                }
                for (int y = m - i - 1; y > i; --y) {
                    grid[y][j] = grid[y - 1][j];
                }
                grid[i + 1][j] = tmp;
            }
            i++;
            j++;
            m--;
            n--;
        }
        return grid;
    }
};