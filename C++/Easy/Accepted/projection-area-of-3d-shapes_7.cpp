class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int top = 0;
        int front = 0;
        int side = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    top++;
                }
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            front += max;
        }
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            side += max;
        }
        return top + front + side;
    }
};