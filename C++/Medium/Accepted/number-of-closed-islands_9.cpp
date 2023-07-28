class Solution {
public:
    int closedIsland(vector<vector<int>>& grid) {
        
        int M = grid.size();
        int N = grid[0].size();
        int cnt = 0;
        for (int i = 1; i < M - 1; ++i) {
            for (int j = 1; j < N - 1; ++j) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    bool dfs(vector<vector<int>>& grid, int i, int j) {
        if (i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size()) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        bool up = dfs(grid, i - 1, j);
        bool down = dfs(grid, i + 1, j);
        bool left = dfs(grid, i, j - 1);
        bool right = dfs(grid, i, j + 1);
        return up && down && left && right;
    }
};