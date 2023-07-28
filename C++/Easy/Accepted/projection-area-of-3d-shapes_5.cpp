class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int top = 0;
        int front = 0;
        int side = 0;
        for (int i = 0; i < n; i++) {
            int maxFront = 0;
            int maxSide = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    top++;
                }
                maxFront = max(maxFront, grid[i][j]);
                maxSide = max(maxSide, grid[j][i]);
            }
            front += maxFront;
            side += maxSide;
        }
        return top + front + side;
    }
};