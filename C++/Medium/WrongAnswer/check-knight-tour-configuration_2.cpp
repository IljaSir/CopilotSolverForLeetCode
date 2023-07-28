class Solution {
public:
    bool checkValidGrid(vector<vector<int>>& grid) {
        
        int n = grid.size();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int value = grid[i][j];
                if (value == n * n - 1) {
                    continue;
                }
                int x = value / n;
                int y = value % n;
                if (i > 0 && j > 1 && grid[i - 1][j - 2] == value + 1) {
                    continue;
                }
                if (i > 1 && j > 0 && grid[i - 2][j - 1] == value + 1) {
                    continue;
                }
                if (i > 1 && j < n - 1 && grid[i - 2][j + 1] == value + 1) {
                    continue;
                }
                if (i > 0 && j < n - 2 && grid[i - 1][j + 2] == value + 1) {
                    continue;
                }
                if (i < n - 1 && j < n - 2 && grid[i + 1][j + 2] == value + 1) {
                    continue;
                }
                if (i < n - 2 && j < n - 1 && grid[i + 2][j + 1] == value + 1) {
                    continue;
                }
                if (i < n - 2 && j > 0 && grid[i + 2][j - 1] == value + 1) {
                    continue;
                }
                if (i < n - 1 && j > 1 && grid[i + 1][j - 2] == value + 1) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
};