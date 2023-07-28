class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        
        int count = 0;
        for (int i = 0; i < grid.size() - 2; i++) {
            for (int j = 0; j < grid[0].size() - 2; j++) {
                if (grid[i + 1][j + 1] == 5 && isValid(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    bool isValid(vector<vector<int>>& grid, int row, int col) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += grid[row][col + i];
        }
        for (int i = 0; i < 3; i++) {
            int temp = 0;
            for (int j = 0; j < 3; j++) {
                temp += grid[row + i][col + j];
            }
            if (temp != sum) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            int temp = 0;
            for (int j = 0; j < 3; j++) {
                temp += grid[row + j][col + i];
            }
            if (temp != sum) {
                return false;
            }
        }
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            temp += grid[row + i][col + i];
        }
        if (temp != sum) {
            return false;
        }
        temp = 0;
        for (int i = 0; i < 3; i++) {
            temp += grid[row + i][col + 2 - i];
        }
        if (temp != sum) {
            return false;
        }
        vector<int> record(10, 0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                record[grid[row + i][col + j]]++;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (record[i] != 1) {
                return false;
            }
        }
        return true;
    }
};