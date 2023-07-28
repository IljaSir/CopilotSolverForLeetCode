class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        
        int row = grid.size();
        int col = grid[0].size();
        int sum = 0;
        while (col > 0) {
            int max = 0;
            int maxRow = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                        maxRow = i;
                    }
                }
            }
            sum += max;
            grid.erase(grid.begin() + maxRow);
            row--;
            col--;
        }
        return sum;
    }
};