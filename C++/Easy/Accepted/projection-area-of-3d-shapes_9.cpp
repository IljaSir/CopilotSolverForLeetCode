class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        
        int area = 0;
        int n = grid.size();
        for(int i = 0; i < n; ++i){
            int top = 0;
            int front = 0;
            for(int j = 0; j < n; ++j){
                if(grid[i][j] > 0){
                    ++area;
                }
                top = max(top, grid[i][j]);
                front = max(front, grid[j][i]);
            }
            area += top + front;
        }
        return area;
    }
};