class Solution {
public:
    int latestDayToCross(int row, int col, vector<vector<int>>& cells) {
        
        int n = cells.size();
        vector<vector<int>> g(row, vector<int>(col, 0));
        vector<vector<int>> f(row, vector<int>(col, 0));
        vector<int> dx = {0, 0, 1, -1};
        vector<int> dy = {1, -1, 0, 0};
        auto valid = [&](int x, int y) {
            return x >= 0 && x < row && y >= 0 && y < col;
        };
        auto dfs = [&](int x, int y) {
            if (f[x][y]) return f[x][y];
            f[x][y] = 1;
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (valid(nx, ny) && g[nx][ny] && g[nx][ny] <= g[x][y])
                    f[x][y] = max(f[x][y], dfs(nx, ny) + 1);
            }
            return f[x][y];
        };
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            g[cells[i][0] - 1][cells[i][1] - 1] = i + 1;
            for (int j = 0; j < row; ++j)
                for (int k = 0; k < col; ++k)
                    f[j][k] = 0;
            if (dfs(0, 0) >= row) ans = i + 1;
        }
        return ans;
    }
};