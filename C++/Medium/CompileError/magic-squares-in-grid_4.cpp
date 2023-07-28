class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int res = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (magic(grid[i][j], grid[i][j + 1], grid[i][j + 2],
                          grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                          grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2])) {
                    res++;
                }
            }
        }
        return res;
    }
};