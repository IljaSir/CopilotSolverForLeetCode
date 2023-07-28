class Solution {
public:
    int closedIsland(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        for(int i = 1; i < m - 1; ++i) {
            for(int j = 1; j < n - 1; ++j) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }
    bool dfs(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size();
        int n = grid[0].size();
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        bool res = true;
        res &= dfs(grid, i - 1, j);
        res &= dfs(grid, i, j - 1);
        res &= dfs(grid, i + 1, j);
        res &= dfs(grid, i, j + 1);
        return res;
    }
};