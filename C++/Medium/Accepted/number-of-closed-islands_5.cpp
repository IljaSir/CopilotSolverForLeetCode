class Solution {
public:
    int closedIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    ans += dfs(grid, i, j, visited);
                }
            }
        }
        return ans;
    }
    
    int dfs(vector<vector<int>>& grid, int i, int j, vector<vector<bool>>& visited) {
        int n = grid.size();
        int m = grid[0].size();
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }
        if (visited[i][j] || grid[i][j] == 1) {
            return 1;
        }
        visited[i][j] = true;
        int ans = 1;
        ans &= dfs(grid, i, j - 1, visited);
        ans &= dfs(grid, i, j + 1, visited);
        ans &= dfs(grid, i - 1, j, visited);
        ans &= dfs(grid, i + 1, j, visited);
        return ans;
    }
};