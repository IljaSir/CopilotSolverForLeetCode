class Solution {
public:
    int getMaximumGold(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        int maxGold = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    maxGold = max(maxGold, dfs(grid, i, j, visited));
                }
            }
        }
        return maxGold;
    }
};