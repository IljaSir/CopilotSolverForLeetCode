class Solution {
public:
    int minDays(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (count > 1) return 0;
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        if (count == 0) return 0;
        if (count == 1) return 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    count = 0;
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            if (grid[i][j] == 1) {
                                if (count > 1) return 2;
                                count++;
                                dfs(grid, i, j);
                            }
                        }
                    }
                    return 2;
                }
            }
        }
        return 0;
    }
};