class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();
        int res = 0;
        while (m > 0) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                    }
                }
            }
            res += max;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == max) {
                        grid[i].erase(grid[i].begin() + j);
                        m--;
                        j--;
                    }
                }
            }
        }
        return res;
    }
};