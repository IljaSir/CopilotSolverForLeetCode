class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int startRow = 0;
        int startCol = 0;
        int endRow = n - 1;
        int endCol = m - 1;
        int i = 0;
        int j = 0;
        int count = 0;
        while (count < n * m) {
            if (i < startRow || i > endRow || j < startCol || j > endCol) {
                return false;
            }
            if (grid[i][j] == count) {
                count++;
            } else {
                return false;
            }
            if (i == startRow && j == startCol) {
                startRow++;
                startCol++;
            } else if (i == startRow && j == endCol) {
                startRow++;
                endCol--;
            } else if (i == endRow && j == startCol) {
                endRow--;
                startCol++;
            } else if (i == endRow && j == endCol) {
                endRow--;
                endCol--;
            }
            if (i == startRow) {
                j++;
            } else if (i == endRow) {
                j--;
            } else if (j == startCol) {
                i++;
            } else if (j == endCol) {
                i--;
            }
        }
        return true;
    }
    bool checkValidKnightTour(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<int> dx = {1, 1, -1, -1, 2, 2, -2, -2};
        vector<int> dy = {2, -2, 2, -2, 1, -1, 1, -1};
        int i = 0;
        int j = 0;
        int count = 0;
        while (count < n * m) {
            if (i < 0 || i >= n || j < 0 || j >= m) {
                return false;
            }
            if (grid[i][j] == count) {
                count++;
            } else {
                return false;
            }
            for (int k = 0; k < 8; k++) {
                int x = i + dx[k];
    }
};