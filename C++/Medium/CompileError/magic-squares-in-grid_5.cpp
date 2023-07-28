class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int ans = 0;
        for (int i = 0; i <= m - 3; ++i) {
            for (int j = 0; j <= n - 3; ++j) {
                if (grid[i + 1][j + 1] != 5) continue;
                if (magic(grid, i, j)) ++ans;
            }
        }
        return ans;
    }
    bool magic(vector<vector<int>>& grid, int i, int j) {
        vector<int> cnt(16, 0);
        for (int x = i; x < i + 3; ++x) {
            for (int y = j; y < j + 3; ++y) {
                if (grid[x][y] < 1 || grid[x][y] > 9) return false;
                ++cnt[grid[x][y]];
            }
        }
        for (int i = 1; i <= 9; ++i) {
            if (cnt[i] != 1) return false;
        }
        if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) return false;
        if (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != 15) return false;
        if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15) return false;
        if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) return false;
        if (grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != 15) return false;
        if (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != 15) return false;
        if (grid[i][j] + grid[i + 1][j + 1] + grid[i
    }
};