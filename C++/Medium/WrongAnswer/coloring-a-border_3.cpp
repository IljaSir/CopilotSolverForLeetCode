class Solution {
public:
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int oldColor = grid[row][col];
        dfs(grid, visited, row, col, m, n, oldColor);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (visited[i][j]) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
    
    void dfs(vector<vector<int>>& grid, vector<vector<bool>>& visited, int row, int col, int m, int n, int oldColor) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != oldColor) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        if (row == 0 || row == m - 1 || col == 0 || col == n - 1) {
            grid[row][col] = -1;
        } else {
            if (grid[row + 1][col] != oldColor) {
                grid[row][col] = -1;
            }
            if (grid[row - 1][col] != oldColor) {
                grid[row][col] = -1;
            }
            if (grid[row][col + 1] != oldColor) {
                grid[row][col] = -1;
            }
            if (grid[row][col - 1] != oldColor) {
                grid[row][col] = -1;
            }
        }
        dfs(grid, visited, row + 1, col, m, n, oldColor);
        dfs(grid, visited, row - 1, col, m, n, oldColor);
        dfs(grid, visited, row, col + 1, m, n, oldColor);
        dfs(grid, visited, row, col - 1, m, n, oldColor);
    }
};