class Solution {
public:
    vector<vector<int>> rotateGrid(vector<vector<int>>& grid, int k) {
        
        int m = grid.size();
        int n = grid[0].size();
        int layer = min(m, n) / 2;
        for (int l = 0; l < layer; l++) {
            int len = (m - 2 * l - 1) + (n - 2 * l - 1) + (m - 2 * l - 1) + (n - 2 * l - 1);
            int kk = k % len;
            while (kk--) {
                int tmp = grid[l][l];
                for (int i = l + 1; i < m - l; i++) {
                    grid[i - 1][l] = grid[i][l];
                }
                for (int j = l + 1; j < n - l; j++) {
                    grid[m - l - 1][j - 1] = grid[m - l - 1][j];
                }
                for (int i = m - l - 2; i >= l; i--) {
                    grid[i + 1][n - l - 1] = grid[i][n - l - 1];
                }
                for (int j = n - l - 2; j >= l; j--) {
                    grid[l][j + 1] = grid[l][j];
                }
                grid[l][l + 1] = tmp;
            }
        }
        return grid;
    }
};