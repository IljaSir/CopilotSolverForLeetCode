class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        // left and right
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if (grid[i][n-1] == 1) {
                dfs(grid, i, n-1);
            }
        }
        // top and bottom
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if (grid[m-1][j] == 1) {
                dfs(grid, m-1, j);
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }
    
    void dfs(vector<vector<int>>& grid, int i, int j) {
        grid[i][j] = 0;
        if (i > 0 && grid[i-1][j] == 1) {
            dfs(grid, i-1, j);
        }
        if (i < grid.size()-1 && grid[i+1][j] == 1) {
            dfs(grid, i+1, j);
        }
        if (j > 0 && grid[i][j-1] == 1) {
            dfs(grid, i, j-1);
        }
        if (j < grid[0].size()-1 && grid[i][j+1] == 1) {
            dfs(grid, i, j+1);
        }
    }
};