class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = 0, y = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) res++;
                x = max(x, grid[i][j]);
                y = max(y, grid[j][i]);
            }
            res += x + y;
        }
        return res;
    }
};