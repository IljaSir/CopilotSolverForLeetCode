class Solution {
public:
    int largest1BorderedSquare(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> up(m, vector<int>(n, 0));
        vector<vector<int>> left(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                up[i][j] = (i == 0) ? 1 : up[i - 1][j] + 1;
                left[i][j] = (j == 0) ? 1 : left[i][j - 1] + 1;
            }
        }
        for (int k = min(m, n); k > 0; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (up[i + k - 1][j] >= k && up[i + k - 1][j + k - 1] >= k
                        && left[i][j + k - 1] >= k && left[i + k - 1][j + k - 1] >= k) {
                        return k * k;
                    }
                }
            }
        }
        return 0;
    }
};