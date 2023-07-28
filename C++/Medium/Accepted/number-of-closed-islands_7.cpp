class Solution {
public:
    int closedIsland(vector<vector<int>>& grid) {
        
        int ans = 0;
        int m = grid.size(), n = grid[0].size();
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    bool dfs(vector<vector<int>>& grid, int i, int j) {
        int m = grid.size(), n = grid[0].size();
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        bool left = dfs(grid, i, j - 1);
        bool right = dfs(grid, i, j + 1);
        bool up = dfs(grid, i - 1, j);
        bool down = dfs(grid, i + 1, j);
        return left && right && up && down;
    }
};