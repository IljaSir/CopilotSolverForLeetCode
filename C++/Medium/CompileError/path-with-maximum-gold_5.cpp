class Solution {
public:
    int getMaximumGold(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int maxGold = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    int gold = dfs(grid, i, j);
                    maxGold = max(maxGold, gold);
                }
            }
        }
        return maxGold;
    }
};