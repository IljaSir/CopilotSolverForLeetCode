class Solution {
public:
    int minDays(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int island = 0;
        int island2 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        if (island > 1) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    island2++;
                    grid[i][j] = 0;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            if (grid[k][l] == 1) {
                                dfs(grid, k, l, m, n);
                            }
                        }
                    }
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            if (grid[k][l] == 1) {
                                return 1;
                            }
                        }
                    }
                    if (island2 > 1) return 2;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
    void dfs(vector<vector<int>>& grid, int i, int j, int m, int n) {
        int dirs[5] = {0, 1, 0, -1, 0};
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k];
            int y = j + dirs[k + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                dfs(grid, x, y, m, n);
            }
        }
    }
};