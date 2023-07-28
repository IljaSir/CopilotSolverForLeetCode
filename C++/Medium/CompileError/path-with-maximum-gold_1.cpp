class Solution {
public:
    int getMaximumGold(vector<vector<int>>& grid) {
        
        int res = 0;
        for (int i = 0; i < grid.size(); ++i) {
            for (int j = 0; j < grid[0].size(); ++j) {
                if (grid[i][j] > 0) {
                    res = max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }
};