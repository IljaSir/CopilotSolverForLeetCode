class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> res(n-2, vector<int>(n-2, 0));
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < n - 1; j++){
                int max = grid[i-1][j-1];
                max = max > grid[i-1][j] ? max : grid[i-1][j];
                max = max > grid[i-1][j+1] ? max : grid[i-1][j+1];
                max = max > grid[i][j-1] ? max : grid[i][j-1];
                max = max > grid[i][j] ? max : grid[i][j];
                max = max > grid[i][j+1] ? max : grid[i][j+1];
                max = max > grid[i+1][j-1] ? max : grid[i+1][j-1];
                max = max > grid[i+1][j] ? max : grid[i+1][j];
                max = max > grid[i+1][j+1] ? max : grid[i+1][j+1];
                res[i-1][j-1] = max;
            }
        }
        return res;
    }
};