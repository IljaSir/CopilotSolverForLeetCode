class Solution {
public:
    int countPyramids(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                for (int h = 1; i + h < m && j - h >= 0 && j + h < n; ++h) {
                    if (grid[i + h][j - h] == 0 || grid[i + h][j + h] == 0) break;
                    ++res;
                }
                for (int h = 1; i - h >= 0 && j - h >= 0 && j + h < n; ++h) {
                    if (grid[i - h][j - h] == 0 || grid[i - h][j + h] == 0) break;
                    ++res;
                }
            }
        }
        return res;
    }
};