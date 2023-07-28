class Solution {
public:
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        
        int n = grid.size();
        int m = grid[0].size();
        int oldColor = grid[row][col];
        if (oldColor == color) return grid;
        dfs(grid, row, col, oldColor, color);
        return grid;
    }
    void dfs(vector<vector<int>>& grid, int row, int col, int oldColor, int newColor) {
        int n = grid.size();
        int m = grid[0].size();
        if (row < 0 || row >= n || col < 0 || col >= m) return;
        if (grid[row][col] != oldColor) return;
        grid[row][col] = -1;
        dfs(grid, row-1, col, oldColor, newColor);
        dfs(grid, row+1, col, oldColor, newColor);
        dfs(grid, row, col-1, oldColor, newColor);
        dfs(grid, row, col+1, oldColor, newColor);
        if (row > 0 && row < n-1 && col > 0 && col < m-1) {
            if (grid[row-1][col] == oldColor && grid[row+1][col] == oldColor && grid[row][col-1] == oldColor && grid[row][col+1] == oldColor) {
                grid[row][col] = oldColor;
            }
        }
        if (grid[row][col] == -1) {
            grid[row][col] = newColor;
        }
    }
};