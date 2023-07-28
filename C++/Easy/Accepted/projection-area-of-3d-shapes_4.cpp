class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        
        int top = 0;
        int front = 0;
        int side = 0;
        for (int i = 0; i < grid.size(); i++) {
            int max = 0;
            for (int j = 0; j < grid[i].size(); j++) {
                if (grid[i][j] > 0) {
                    top++;
                }
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            front += max;
        }
        for (int j = 0; j < grid[0].size(); j++) {
            int max = 0;
            for (int i = 0; i < grid.size(); i++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            side += max;
        }
        return top + front + side;
    }
};