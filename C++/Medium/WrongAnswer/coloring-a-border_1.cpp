class Solution {
public:
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        
        dfs(grid, row, col, grid[row][col], color);
        return grid;
    }
    
    void dfs(vector<vector<int>>& grid, int row, int col, int oldColor, int newColor) {
        if (row < 0 || col < 0 || row >= grid.size() || col >= grid[0].size() || grid[row][col] != oldColor)
            return;
        grid[row][col] = -oldColor; // mark as visited
        dfs(grid, row+1, col, oldColor, newColor);
        dfs(grid, row-1, col, oldColor, newColor);
        dfs(grid, row, col+1, oldColor, newColor);
        dfs(grid, row, col-1, oldColor, newColor);
        if ((row > 0 && grid[row-1][col] == oldColor) || (col > 0 && grid[row][col-1] == oldColor) ||
            (row < grid.size()-1 && grid[row+1][col] == oldColor) || (col < grid[0].size()-1 && grid[row][col+1] == oldColor)) {
            grid[row][col] = oldColor;
        } else {
            grid[row][col] = newColor;
        }
    }
};