class Solution {
public:
    int countPyramids(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int cnt = 0;
        // check pyramid
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int h = 1;
                    while (r + h < m && c - h >= 0 && c + h < n) {
                        if (grid[r + h][c - h] == 0 || grid[r + h][c + h] == 0) {
                            break;
                        }
                        h++;
                    }
                    if (h > 1) {
                        cnt += h - 1;
                    }
                }
            }
        }
        // check inverse pyramid
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int h = 1;
                    while (r - h >= 0 && c - h >= 0 && c + h < n) {
                        if (grid[r - h][c - h] == 0 || grid[r - h][c + h] == 0) {
                            break;
                        }
                        h++;
                    }
                    if (h > 1) {
                        cnt += h - 1;
                    }
                }
            }
        }
        return cnt;
    }
};