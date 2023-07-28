class Solution {
public:
    int countPyramids(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> up(m, vector<int>(n)), down(m, vector<int>(n)), left(m, vector<int>(n)), right(m, vector<int>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                up[i][j] = (i == 0 ? 0 : up[i - 1][j]) + 1;
                left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
            }
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 0) continue;
                down[i][j] = (i == m - 1 ? 0 : down[i + 1][j]) + 1;
                right[i][j] = (j == n - 1 ? 0 : right[i][j + 1]) + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                int h = min(up[i][j], down[i][j]);
                for (int k = 1; k < h; ++k) {
                    if (left[i - k][j] >= k + 1 && right[i - k][j] >= k + 1) ++ans;
                    if (left[i + k][j] >= k + 1 && right[i + k][j] >= k + 1) ++ans;
                }
            }
        }
        return ans;
    }
};