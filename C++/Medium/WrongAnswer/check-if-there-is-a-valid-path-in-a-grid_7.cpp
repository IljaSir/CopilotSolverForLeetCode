class Solution {
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, 0));
        return dfs(grid, visited, 0, 0, m, n);
    }
    
    bool dfs(vector<vector<int>>& grid, vector<vector<int>>& visited, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1) {
            return false;
        }
        visited[i][j] = 1;
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        if (grid[i][j] == 1) {
            return dfs(grid, visited, i, j + 1, m, n) || dfs(grid, visited, i, j - 1, m, n);
        }
        if (grid[i][j] == 2) {
            return dfs(grid, visited, i + 1, j, m, n) || dfs(grid, visited, i - 1, j, m, n);
        }
        if (grid[i][j] == 3) {
            return dfs(grid, visited, i, j - 1, m, n) || dfs(grid, visited, i + 1, j, m, n);
        }
        if (grid[i][j] == 4) {
            return dfs(grid, visited, i, j + 1, m, n) || dfs(grid, visited, i + 1, j, m, n);
        }
        if (grid[i][j] == 5) {
            return dfs(grid, visited, i, j - 1, m, n) || dfs(grid, visited, i - 1, j, m, n);
        }
        if (grid[i][j] == 6) {
            return dfs(grid, visited, i, j + 1, m, n) || dfs(grid, visited, i - 1, j, m, n);
        }
        return false;
    }
};