class Solution {
public:
    int minDays(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int islands = 0;
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    islands++;
                    dfs(grid, i, j, m, n, dirs);
                }
            }
        }
        if (islands != 1) {
            return 0;
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    islands = 0;
                    for (int ii = 0; ii < m; ++ii) {
                        for (int jj = 0; jj < n; ++jj) {
                            if (grid[ii][jj] == 1) {
                                islands++;
                                dfs(grid, ii, jj, m, n, dirs);
                            }
                        }
                    }
                    if (islands != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
    
    void dfs(vector<vector<int>>& grid, int i, int j, int m, int n, vector<vector<int>>& dirs) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
        grid[i][j] = 0;
        for (auto dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], m, n, dirs);
        }
    }
};