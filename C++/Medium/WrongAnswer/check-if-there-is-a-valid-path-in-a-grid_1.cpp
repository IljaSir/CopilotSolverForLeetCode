class Solution {
public:
    bool hasValidPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        return dfs(grid, visited, 0, 0);
    }
    
    bool dfs(vector<vector<int>>& grid, vector<vector<bool>>& visited, int i, int j) {
        int m = grid.size();
        int n = grid[0].size();
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (visited[i][j]) return false;
        visited[i][j] = true;
        if (i == m - 1 && j == n - 1) return true;
        switch (grid[i][j]) {
            case 1: return dfs(grid, visited, i, j + 1) || dfs(grid, visited, i, j - 1);
            case 2: return dfs(grid, visited, i + 1, j) || dfs(grid, visited, i - 1, j);
            case 3: return dfs(grid, visited, i, j - 1) || dfs(grid, visited, i + 1, j);
            case 4: return dfs(grid, visited, i, j + 1) || dfs(grid, visited, i + 1, j);
            case 5: return dfs(grid, visited, i, j - 1) || dfs(grid, visited, i - 1, j);
            case 6: return dfs(grid, visited, i, j + 1) || dfs(grid, visited, i - 1, j);
        }
        return false;
    }
};