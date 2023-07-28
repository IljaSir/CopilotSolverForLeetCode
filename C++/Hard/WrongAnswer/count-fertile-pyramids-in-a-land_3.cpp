class Solution {
public:
    int countPyramids(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int res = 0;
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (grid[r][c] == 1) {
                    int h = 1;
                    while (r + h < m && c - h >= 0 && c + h < n) {
                        if (grid[r + h][c - h] == 1 && grid[r + h][c + h] == 1) {
                            ++h;
                        } else {
                            break;
                        }
                    }
                    res += h - 1;
                }
            }
        }
        for (int r = 0; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                if (grid[r][c] == 1) {
                    int h = 1;
                    while (r - h >= 0 && c - h >= 0 && c + h < n) {
                        if (grid[r - h][c - h] == 1 && grid[r - h][c + h] == 1) {
                            ++h;
                        } else {
                            break;
                        }
                    }
                    res += h - 1;
                }
            }
        }
        return res;
    }
};