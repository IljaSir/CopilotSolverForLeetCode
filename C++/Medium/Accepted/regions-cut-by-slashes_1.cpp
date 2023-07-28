class Solution {
public:
    int regionsBySlashes(vector<string>& grid) {
        
        int n = grid.size();
        vector<vector<int>> g(n * 3, vector<int>(n * 3, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '/') {
                    g[i * 3][j * 3 + 2] = g[i * 3 + 1][j * 3 + 1] = g[i * 3 + 2][j * 3] = 1;
                } else if (grid[i][j] == '\\') {
                    g[i * 3][j * 3] = g[i * 3 + 1][j * 3 + 1] = g[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n * 3; ++i) {
            for (int j = 0; j < n * 3; ++j) {
                if (g[i][j] == 0) {
                    dfs(g, i, j);
                    ++res;
                }
            }
        }
        return res;
    }
    void dfs(vector<vector<int>>& g, int x, int y) {
        int n = g.size();
        if (x < 0 || x >= n || y < 0 || y >= n || g[x][y] == 1) {
            return;
        }
        g[x][y] = 1;
        dfs(g, x + 1, y);
        dfs(g, x - 1, y);
        dfs(g, x, y + 1);
        dfs(g, x, y - 1);
    }
};