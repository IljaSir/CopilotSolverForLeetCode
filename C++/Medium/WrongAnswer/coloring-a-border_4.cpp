class Solution {
public:
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        int oldColor = grid[row][col];
        dfs(grid, row, col, color, oldColor, visited);
        return grid;
    }
    void dfs(vector<vector<int>>& grid, int row, int col, int color, int oldColor, vector<vector<int>>& visited) {
        int m = grid.size();
        int n = grid[0].size();
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] != oldColor) {
            return;
        }
        visited[row][col] = 1;
        dfs(grid, row - 1, col, color, oldColor, visited);
        dfs(grid, row + 1, col, color, oldColor, visited);
        dfs(grid, row, col - 1, color, oldColor, visited);
        dfs(grid, row, col + 1, color, oldColor, visited);
        if (row > 0 && row < m - 1 && col > 0 && col < n - 1 && grid[row - 1][col] == oldColor && grid[row + 1][col] == oldColor && grid[row][col - 1] == oldColor && grid[row][col + 1] == oldColor) {
            return;
        }
        grid[row][col] = color;
    }
};