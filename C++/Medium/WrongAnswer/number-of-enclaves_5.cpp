class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (isEnclave(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    bool isEnclave(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size();
        int n = grid[0].size();
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        if (grid[i][j] == 0) {
            return true;
        }
        grid[i][j] = 0;
        return isEnclave(grid, i - 1, j) && isEnclave(grid, i + 1, j) && isEnclave(grid, i, j - 1) && isEnclave(grid, i, j + 1);
    }
};