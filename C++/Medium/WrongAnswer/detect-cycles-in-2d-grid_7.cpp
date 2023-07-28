class Solution {
public:
    bool containsCycle(vector<vector<char>>& grid) {
        
        if(grid.size() == 0) return false;
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    if(dfs(grid, visited, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    bool dfs(vector<vector<char>>& grid, vector<vector<bool>>& visited, int i, int j, int pi, int pj) {
        visited[i][j] = true;
        int m = grid.size();
        int n = grid[0].size();
        if(i > 0 && !visited[i-1][j] && grid[i-1][j] == grid[i][j]) {
            if(dfs(grid, visited, i-1, j, i, j)) {
                return true;
            }
        }
        if(i < m-1 && !visited[i+1][j] && grid[i+1][j] == grid[i][j]) {
            if(dfs(grid, visited, i+1, j, i, j)) {
                return true;
            }
        }
        if(j > 0 && !visited[i][j-1] && grid[i][j-1] == grid[i][j]) {
            if(dfs(grid, visited, i, j-1, i, j)) {
                return true;
            }
        }
        if(j < n-1 && !visited[i][j+1] && grid[i][j+1] == grid[i][j]) {
            if(dfs(grid, visited, i, j+1, i, j)) {
                return true;
            }
        }
        if(pi == i && pj == j) {
            return true;
        }
        return false;
    }
};