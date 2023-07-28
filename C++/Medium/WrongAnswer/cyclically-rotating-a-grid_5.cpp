class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        int t = min(m, n) / 2;
        for (int i = 0; i < t; i++) {
            int len = 2 * (m + n - 4 * i) - 4;
            k %= len;
            for (int j = 0; j < k; j++) {
                int temp = grid[i][i];
                for (int x = i; x < n - 1 - i; x++) {
                    grid[i][x] = grid[i][x + 1];
                }
                for (int y = i; y < m - 1 - i; y++) {
                    grid[y][n - 1 - i] = grid[y + 1][n - 1 - i];
                }
                for (int x = n - 1 - i; x > i; x--) {
                    grid[m - 1 - i][x] = grid[m - 1 - i][x - 1];
                }
                for (int y = m - 1 - i; y > i + 1; y--) {
                    grid[y][i] = grid[y - 1][i];
                }
                grid[i + 1][i] = temp;
            }
        }
        return grid;
    }
};