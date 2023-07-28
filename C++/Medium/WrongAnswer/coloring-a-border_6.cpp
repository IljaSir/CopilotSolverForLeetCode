class Solution {
public:
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        
        int m = grid.size();
        int n = grid[0].size();
        int oldColor = grid[row][col];
        vector<vector<int>> visited(m, vector<int>(n, 0));
        dfs(grid, visited, row, col, color, oldColor);
        return grid;
    }
    void dfs(vector<vector<int>>& grid, vector<vector<int>>& visited, int row, int col, int color, int oldColor) {
        int m = grid.size();
        int n = grid[0].size();
        if (row < 0 || row >= m || col < 0 || col >= n) return;
        if (visited[row][col] == 1) return;
        if (grid[row][col] != oldColor) return;
        visited[row][col] = 1;
        if (row == 0 || row == m-1 || col == 0 || col == n-1) {
            grid[row][col] = color;
        } else if (grid[row+1][col] != oldColor || grid[row-1][col] != oldColor || grid[row][col+1] != oldColor || grid[row][col-1] != oldColor) {
            grid[row][col] = color;
        }
        dfs(grid, visited, row+1, col, color, oldColor);
        dfs(grid, visited, row-1, col, color, oldColor);
        dfs(grid, visited, row, col+1, color, oldColor);
        dfs(grid, visited, row, col-1, color, oldColor);
    }
};