class Solution {
public:
    int largestMagicSquare(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> row(m, vector<int>(n, 0)), col(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                row[i][j] = grid[i][j] + (j > 0 ? row[i][j - 1] : 0);
                col[i][j] = grid[i][j] + (i > 0 ? col[i - 1][j] : 0);
            }
        }
        for (int k = min(m, n); k >= 2; --k) {
            for (int i = 0; i <= m - k; ++i) {
                for (int j = 0; j <= n - k; ++j) {
                    int sum = row[i][j + k - 1] - (j > 0 ? row[i][j - 1] : 0);
                    bool ok = true;
                    for (int p = 1; p < k; ++p) {
                        int cur = row[i + p][j + k - 1] - (j > 0 ? row[i + p][j - 1] : 0);
                        if (cur != sum) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;
                    for (int p = 0; p < k; ++p) {
                        int cur = col[i + k - 1][j + p] - (i > 0 ? col[i - 1][j + p] : 0);
                        if (cur != sum) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;
                    int cur = 0;
                    for (int p = 0; p < k; ++p) {
                        cur += grid[i + p][j + p];
                    }
                    if (cur != sum) continue;
                    cur = 0;
                    for (int p = 0; p < k; ++p) {
                        cur += grid[i + p][j + k - 1 - p];
                    }
                    if (cur == sum) return k
    }
};