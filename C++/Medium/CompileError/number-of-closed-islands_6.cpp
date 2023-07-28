class Solution {
public:
    int closedIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        
        for (int i = 0; i < n; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, m-1);
        }
        
        for (int j = 0; j < m; j++) {
            dfs(grid, 0, j);
            dfs(grid, n-1, j);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return ans;
    }
};