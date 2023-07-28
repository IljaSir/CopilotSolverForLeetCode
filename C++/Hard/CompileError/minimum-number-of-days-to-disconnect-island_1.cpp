class Solution {
public:
    int minDays(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    count++;
                    if (count > 1) return 0;
                    dfs(grid, i, j);
                }
        if (count == 0) return 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    count = 0;
                    for (int p = 0; p < m; p++)
                        for (int q = 0; q < n; q++)
                            if (grid[p][q] == 1) {
                                count++;
                                if (count > 1) return 1;
                                dfs(grid, p, q);
                            }
                    return 2;
                }
        return 0;
    }
};