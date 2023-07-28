class Solution {
public:
    int getMaximumGold(vector<vector<int>>& grid) {
        
        int res = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] > 0) {
                    res = max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }
    
    int dfs(vector<vector<int>>& grid, int i, int j) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] == 0) {
            return 0;
        }
        int gold = grid[i][j];
        grid[i][j] = 0;
        int res = gold + max({dfs(grid, i + 1, j), dfs(grid, i - 1, j), dfs(grid, i, j + 1), dfs(grid, i, j - 1)});
        grid[i][j] = gold;
        return res;
    }
};