class Solution {
public:
    int minDays(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int islands = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ++islands;
                    dfs(grid, i, j);
                }
            }
        }
        if (islands == 0) return 0;
        if (islands > 1) return 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int newIslands = 0;
                    for (int k = 0; k < n; ++k) {
                        for (int l = 0; l < m; ++l) {
                            if (grid[k][l] == 1) {
                                ++newIslands;
                                dfs(grid, k, l);
                            }
                        }
                    }
                    if (newIslands > 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
};