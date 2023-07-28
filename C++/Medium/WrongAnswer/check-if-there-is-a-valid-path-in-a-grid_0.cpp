class Solution {
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        return dfs(grid, 0, 0, visited);
    }
    
    bool dfs(vector<vector<int>>& grid, int i, int j, vector<vector<bool>>& visited) {
        if (i == grid.size() - 1 && j == grid[0].size() - 1) return true;
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size()) return false;
        if (visited[i][j]) return false;
        visited[i][j] = true;
        if (grid[i][j] == 1) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i, j - 1, visited);
        } else if (grid[i][j] == 2) {
            return dfs(grid, i + 1, j, visited) || dfs(grid, i - 1, j, visited);
        } else if (grid[i][j] == 3) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i + 1, j, visited);
        } else if (grid[i][j] == 4) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i + 1, j, visited);
        } else if (grid[i][j] == 5) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i - 1, j, visited);
        } else if (grid[i][j] == 6) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i - 1, j, visited);
        }
        return false;
    }
};