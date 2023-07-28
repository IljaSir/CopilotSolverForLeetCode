class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        
        int r = grid.size(), c = grid[0].size();
        int res = 0;
        for (int i = 0; i < r - 2; ++i) {
            for (int j = 0; j < c - 2; ++j) {
                if (grid[i + 1][j + 1] != 5) continue;
                vector<int> cnt(16);
                for (int k = 0; k < 3; ++k) {
                    for (int l = 0; l < 3; ++l) {
                        if (grid[i + k][j + l] < 1 || grid[i + k][j + l] > 9) goto next;
                        ++cnt[grid[i + k][j + l]];
                    }
                }
                for (int k = 1; k <= 9; ++k) {
                    if (cnt[k] != 1) goto next;
                }
                if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) goto next;
                if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15) goto next;
                if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) goto next;
                if (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != 15) goto next;
                if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15) goto next;
                if (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15) goto next;
                ++res;
            next:;
            }
        }
        return res;
    }
};