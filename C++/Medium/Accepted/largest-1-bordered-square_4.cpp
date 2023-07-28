class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> row(m, vector<int>(n));
        vector<vector<int>> col(m, vector<int>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    row[i][j] = 1 + (j > 0 ? row[i][j - 1] : 0);
                    col[i][j] = 1 + (i > 0 ? col[i - 1][j] : 0);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int len = min(row[i][j], col[i][j]);
                while (len > res) {
                    if (row[i - len + 1][j] >= len && col[i][j - len + 1] >= len) {
                        res = len;
                        break;
                    }
                    --len;
                }
            }
        }
        return res * res;
    }
};