class Solution {
public:
    int countPyramids(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        vector<vector<int>> row(m, vector<int>(n, 0));
        vector<vector<int>> col(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j]) {
                    row[i][j] = j ? row[i][j - 1] + 1 : 1;
                    col[i][j] = i ? col[i - 1][j] + 1 : 1;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j]) {
                    int h = 1;
                    while (i + h < m && j - h >= 0 && j + h < n && col[i + h][j] >= h + 1 && row[i + h][j - h] >= h + 1 && row[i + h][j + h] >= h + 1) {
                        ++h;
                    }
                    ans += h - 1;
                    h = 1;
                    while (i - h >= 0 && j - h >= 0 && j + h < n && col[i][j] >= h + 1 && row[i][j - h] >= h + 1 && row[i][j + h] >= h + 1) {
                        ++h;
                    }
                    ans += h - 1;
                }
            }
        }
        return ans;
    }
};