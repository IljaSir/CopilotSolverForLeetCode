class Solution {
public:
    int countPyramids(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                int h = 1;
                while (i+h < m && j-h >= 0 && j+h < n) {
                    if (grid[i+h][j-h] == 0 || grid[i+h][j+h] == 0) break;
                    ++h;
                    ++res;
                }
            }
        }
        return res;
    }
    int countInversePyramids(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) continue;
                int h = 1;
                while (i-h >= 0 && j-h >= 0 && j+h < n) {
                    if (grid[i-h][j-h] == 0 || grid[i-h][j+h] == 0) break;
                    ++h;
                    ++res;
                }
            }
        }
        return res;
    }
};