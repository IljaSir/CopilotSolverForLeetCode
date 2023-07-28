class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> left(m, vector<int>(n, 0));
        vector<vector<int>> top(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                    top[i][j] = (i == 0 ? 0 : top[i - 1][j]) + 1;
                }
            }
        }
        for (int len = min(m, n); len > 0; len--) {
            for (int i = 0; i + len <= m; i++) {
                for (int j = 0; j + len <= n; j++) {
                    if (top[i + len - 1][j] >= len && left[i][j + len - 1] >= len && top[i][j] >= len && left[i + len - 1][j] >= len) {
                        return len * len;
                    }
                }
            }
        }
        return 0;
    }
};