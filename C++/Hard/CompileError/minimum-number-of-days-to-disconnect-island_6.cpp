class Solution {
public:
    int minDays(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int islands = 0;
        int waters = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    waters += dfs(grid, i, j);
                }
            }
        }
        if (islands == 0) {
            return 0;
        }
        if (waters == 0) {
            return 1;
        }
        return 2;
    }
};