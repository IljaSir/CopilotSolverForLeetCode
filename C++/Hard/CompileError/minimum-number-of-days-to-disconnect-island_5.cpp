class Solution {
public:
    int minDays(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        auto dfs = [&](int x, int y) {
            int cnt = 1;
            grid[x][y] = 0;
            for (auto& d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) continue;
                cnt += dfs(nx, ny);
            }
            return cnt;
        };
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                ++cnt;
                if (cnt > 1) return 0;
                int area = dfs(i, j);
                if (area != m * n) return 1;
            }
        }
        return 0;
    }
};