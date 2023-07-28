class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> row(m, vector<int>(n)), col(m, vector<int>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                row[i][j] = (j == 0 ? 0 : row[i][j - 1]) + 1;
                col[i][j] = (i == 0 ? 0 : col[i - 1][j]) + 1;
            }
        }
        for (int len = min(m, n); len > 0; --len) {
            for (int i = 0; i + len <= m; ++i) {
                for (int j = 0; j + len <= n; ++j) {
                    if (row[i][j + len - 1] >= len && row[i + len - 1][j + len - 1] >= len &&
                        col[i + len - 1][j] >= len && col[i + len - 1][j + len - 1] >= len)
                        return len * len;
                }
            }
        }
        return 0;
    }
};