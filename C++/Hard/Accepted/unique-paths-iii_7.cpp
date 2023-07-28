class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int starti = -1, startj = -1;
        int endi = -1, endj = -1;
        int zeros = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    starti = i;
                    startj = j;
                }
                if (grid[i][j] == 2) {
                    endi = i;
                    endj = j;
                }
                if (grid[i][j] == 0) {
                    zeros++;
                }
            }
        }
        return dfs(grid, starti, startj, endi, endj, zeros);
    }
    int dfs(vector<vector<int>>& grid, int i, int j, int endi, int endj, int zeros) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] == -1) {
            return 0;
        }
        if (i == endi && j == endj) {
            return zeros == -1 ? 1 : 0;
        }
        grid[i][j] = -1;
        int res = dfs(grid, i + 1, j, endi, endj, zeros - 1) + dfs(grid, i - 1, j, endi, endj, zeros - 1) + dfs(grid, i, j + 1, endi, endj, zeros - 1) + dfs(grid, i, j - 1, endi, endj, zeros - 1);
        grid[i][j] = 0;
        return res;
    }
};