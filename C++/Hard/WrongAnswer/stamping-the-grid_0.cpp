class Solution {
public:
    bool possibleToStamp(vector<vector<int>>& grid, int stampHeight, int stampWidth) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<int> row(m, 0);
        vector<int> col(n, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }
        int stampSize = stampHeight * stampWidth;
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    total += 1;
                }
            }
        }
        int cnt = 0;
        while (cnt < total) {
            int prev = cnt;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (row[i] == stampWidth && col[j] == stampHeight) {
                        for (int ii = i; ii < i + stampHeight; ii++) {
                            for (int jj = j; jj < j + stampWidth; jj++) {
                                if (grid[ii][jj]) {
                                    row[ii] -= 1;
                                    col[jj] -= 1;
                                    grid[ii][jj] = 0;
                                    cnt += 1;
                                }
                            }
                        }
                    }
                }
            }
            if (cnt == prev) {
                return false;
            }
        }
        return true;
    }
};