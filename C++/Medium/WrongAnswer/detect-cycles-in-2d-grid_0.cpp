class Solution {
public:
    bool containsCycle(vector<vector<char>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, grid, visited, i, j, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    bool dfs(int i, int j, vector<vector<char>>& grid, vector<vector<bool>>& visited, int pi, int pj, char c) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] != c) {
            return false;
        }
        if (visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        if (dfs(i - 1, j, grid, visited, i, j, c) || dfs(i + 1, j, grid, visited, i, j, c) || dfs(i, j - 1, grid, visited, i, j, c) || dfs(i, j + 1, grid, visited, i, j, c)) {
            return true;
        }
        return false;
    }
};