class Solution {
public:
    int countPyramids(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j]) {
                    int k = 1;
                    while (i + k < m && j + k < n && j - k >= 0 && grid[i + k][j] && grid[i + k][j + k] && grid[i + k][j - k]) {
                        ++k;
                    }
                    res += k - 1;
                    k = 1;
                    while (i + k < m && j + k < n && j - k >= 0 && grid[i + k][j] && grid[i + k][j + k] && grid[i + k][j - k]) {
                        ++k;
                    }
                    res += k - 1;
                }
            }
        }
        return res;
    }
};