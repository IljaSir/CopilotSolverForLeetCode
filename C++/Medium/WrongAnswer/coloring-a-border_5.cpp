class Solution {
public:
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        
        int m = grid.size();
        int n = grid[0].size();
        int oldColor = grid[row][col];
        vector<vector<int>> visited(m, vector<int>(n, 0));
        dfs(grid, visited, row, col, oldColor);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = color;
                } else if (grid[i][j] == -2) {
                    grid[i][j] = oldColor;
                } else if (grid[i][j] == oldColor) {
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        grid[i][j] = -1;
                    } else {
                        if (grid[i - 1][j] != oldColor || grid[i + 1][j] != oldColor || grid[i][j - 1] != oldColor || grid[i][j + 1] != oldColor) {
                            grid[i][j] = -1;
                        }
                    }
                }
            }
        }
        return grid;
    }
    void dfs(vector<vector<int>>& grid, vector<vector<int>>& visited, int row, int col, int oldColor) {
        if (row < 0 || col < 0 || row >= grid.size() || col >= grid[0].size() || visited[row][col] == 1 || grid[row][col] != oldColor) {
            return;
        }
        visited[row][col] = 1;
        grid[row][col] = -2;
        dfs(grid, visited, row + 1, col, oldColor);
        dfs(grid, visited, row - 1, col, oldColor);
        dfs(grid, visited, row, col + 1, oldColor);
        dfs(grid, visited, row, col - 1, oldColor);
    }
};