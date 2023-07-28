class Solution {
public:
    vector<vector<int>> colorBorder(vector<vector<int>>& grid, int row, int col, int color) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> res = grid;
        if (m == 1 || n == 1) return res;
        
        int target = grid[row][col];
        if (color == target) return res;
        
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        dfs(grid, res, visited, row, col, color, target);
        return res;
    }
    
    void dfs(vector<vector<int>>& grid, vector<vector<int>>& res, vector<vector<bool>>& visited, int row, int col, int color, int target) {
        int m = grid.size();
        int n = grid[0].size();
        if (row < 0 || row >= m || col < 0 || col >= n) return;
        if (grid[row][col] != target) return;
        if (visited[row][col]) return;
        visited[row][col] = true;
        
        if (row == 0 || col == 0 || row == m - 1 || col == n - 1) {
            res[row][col] = color;
        } else {
            if (grid[row - 1][col] != target || grid[row + 1][col] != target || grid[row][col - 1] != target || grid[row][col + 1] != target) {
                res[row][col] = color;
            }
        }
        
        dfs(grid, res, visited, row - 1, col, color, target);
        dfs(grid, res, visited, row + 1, col, color, target);
        dfs(grid, res, visited, row, col - 1, color, target);
        dfs(grid, res, visited, row, col + 1, color, target);
    }
};