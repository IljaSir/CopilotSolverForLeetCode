class Solution {
public:
    int getMaximumGold(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int maxGold = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    maxGold = max(maxGold, dfs(grid, i, j, m, n));
                }
            }
        }
        return maxGold;
    }
    int dfs(vector<vector<int>>& grid, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return 0;
        }
        int gold = grid[x][y];
        grid[x][y] = 0;
        int maxGold = 0;
        maxGold = max(maxGold, gold + dfs(grid, x + 1, y, m, n));
        maxGold = max(maxGold, gold + dfs(grid, x - 1, y, m, n));
        maxGold = max(maxGold, gold + dfs(grid, x, y + 1, m, n));
        maxGold = max(maxGold, gold + dfs(grid, x, y - 1, m, n));
        grid[x][y] = gold;
        return maxGold;
    }
};