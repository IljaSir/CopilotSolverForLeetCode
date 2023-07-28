class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        
        int count = 0;
        for (int i = 0; i < grid.size() - 2; i++) {
            for (int j = 0; j < grid[i].size() - 2; j++) {
                if (grid[i + 1][j + 1] != 5) continue;
                if (grid[i][j] > 9 || grid[i][j + 1] > 9 || grid[i][j + 2] > 9) continue;
                if (grid[i + 1][j] > 9 || grid[i + 1][j + 2] > 9) continue;
                if (grid[i + 2][j] > 9 || grid[i + 2][j + 1] > 9 || grid[i + 2][j + 2] > 9) continue;
                if (grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) continue;
                if (grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15) continue;
                if (grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) continue;
                if (grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != 15) continue;
                if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15) continue;
                if (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15) continue;
                count++;
            }
        }
        return count;
    }
};