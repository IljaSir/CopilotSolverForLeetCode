class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int n0 = 0;
        int sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) n0++;
                else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }
        return dfs(grid, m, n, n0, sx, sy);
    }
    
    int dfs(vector<vector<int>>& grid, int m, int n, int n0, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1) return 0;
        if (grid[x][y] == 2) return n0 == -1;
        grid[x][y] = -1;
        int res = dfs(grid, m, n, n0 - 1, x + 1, y) + dfs(grid, m, n, n0 - 1, x - 1, y) + dfs(grid, m, n, n0 - 1, x, y + 1) + dfs(grid, m, n, n0 - 1, x, y - 1);
        grid[x][y] = 0;
        return res;
    }
};