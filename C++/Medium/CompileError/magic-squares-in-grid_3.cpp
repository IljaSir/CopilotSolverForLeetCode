class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        
        int res = 0;
        for (int i = 0; i + 2 < grid.size(); ++i) {
            for (int j = 0; j + 2 < grid[0].size(); ++j) {
                if (grid[i + 1][j + 1] != 5) continue;  // optional skip
                if (magic(grid[i][j], grid[i][j + 1], grid[i][j + 2],
                          grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                          grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2]))
                    res++;
            }
        }
        return res;
    }
};