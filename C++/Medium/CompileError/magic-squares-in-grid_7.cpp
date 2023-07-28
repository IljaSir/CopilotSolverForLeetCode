class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size(), ans = 0;
        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (grid[i + 1][j + 1] != 5) continue; // optional skip
                int s = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] + grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                if (s != 45) continue;
                if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15) continue;
                if (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15) continue;
                if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) continue;
                if (grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] != 15) continue;
                if (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != 15) continue;
                if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) continue;
                if (grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] != 15) continue;
                if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15) continue;
                ans++;
            }
        }
        return ans
    }
};