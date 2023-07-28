class Solution {
public:
    int minDays(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        vector<vector<int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j, dirs);
                    if (count > 1) {
                        return 0;
                    }
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int count = 0;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            if (grid[k][l] == 1) {
                                count++;
                                dfs(grid, k, l, dirs);
                                if (count > 1) {
                                    return 1;
                                }
                            }
                        }
                    }
                    return 2;
                }
            }
        }
        return 0;
    }
    void dfs(vector<vector<int>>& grid, int i, int j, vector<vector<int>>& dirs) {
        int m = grid.size();
        int n = grid[0].size();
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        for (auto& dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1], dirs);
        }
    }
};