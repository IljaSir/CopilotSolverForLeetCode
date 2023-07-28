class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        
        int result = 0;
        int row = grid.size();
        int col = grid[0].size();
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (magic(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }
    bool magic(vector<vector<int>>& grid, int i, int j) {
        int row = grid.size();
        int col = grid[0].size();
        vector<int> count(10, 0);
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (grid[i + k][j + l] < 1 || grid[i + k][j + l] > 9) {
                    return false;
                }
                count[grid[i + k][j + l]]++;
            }
        }
        for (int k = 1; k <= 9; k++) {
            if (count[k] != 1) {
                return false;
            }
        }
        if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) {
            return false;
        }
        if (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != 15) {
            return false;
        }
        if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15) {
            return false;
        }
        if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) {
            return false;
        }
        if (grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != 15) {
            return false;
        }
        if (grid[i][j +
    }
};