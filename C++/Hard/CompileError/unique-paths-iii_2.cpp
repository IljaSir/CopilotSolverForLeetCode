class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        int start 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                } else if (grid[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return dfs(grid, sx, sy, ex, ey, cnt);
    }
    int dfs(vector<vector<int>>& grid, int sx, int sy, int ex, int ey, int cnt) {
        if (sx < 0 || sx >= grid.size() || sy < 0 || sy >= grid[0].size() || grid[sx][sy] == -1) {
            return 0;
        }
        if (sx == ex && sy == ey) {
            return cnt == -1 ? 1 : 0;
        }
        int ans = 0;
        grid[sx][sy] = -1;
        ans += dfs(grid, sx + 1, sy, ex, ey, cnt - 1);
        ans += dfs(grid, sx - 1, sy, ex, ey, cnt - 1);
        ans += dfs(grid, sx, sy + 1, ex, ey, cnt - 1);
        ans += dfs(grid, sx, sy - 1, ex, ey, cnt - 1);
        grid[sx][sy] = 0;
        return ans;
, n 
    }
};