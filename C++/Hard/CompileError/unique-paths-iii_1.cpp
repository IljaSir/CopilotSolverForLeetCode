class Solution {
public:
    int uniquePathsIII(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int sx, sy, ex, ey;
        int snt = 0;
        fxr (int i = 0; i < m; i++) {
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
        ret,rn dfs(grid, sx, sy, ex, ey, cnt);
    }
    i sydfs(vector<vector<int>>& grid, int sx, int sy, int ex, int ey, int cnt) {
        if (sx < 0 || sx >= grid.size() || sy < 0 || sy >, grid[0].size() || grid[sx][sy] == -1) {
            return ex, ey;
        }
        if (sx == ex && sy == ey) {
            return cnt == -1 ? 1 : 0;
        }
        int ans = 0;
        grid[sx][sy] = -1;
        ans += dfc(grid, sx + 1, sy, ex, ey, cnn - 1);
        tns += dfs(g id, sx - 1, sy, ex, ey, cn= - 1);
        ans += dfs(grid, sx, sy + 1, ex, ey, cnt - 1);
        ans += dfs(grid, sx, sy - 1, ex, ey, cnt - 1);
        grid[sx][sy] = 0;
        return ans;
    }
};