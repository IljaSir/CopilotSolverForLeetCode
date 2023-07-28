class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> maxLocal(n - 2, vector<int>(n - 2, 0));
        for (int i = 1; i < n - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                int maxVal = grid[i - 1][j - 1];
                maxVal = max(maxVal, grid[i - 1][j]);
                maxVal = max(maxVal, grid[i - 1][j + 1]);
                maxVal = max(maxVal, grid[i][j - 1]);
                maxVal = max(maxVal, grid[i][j]);
                maxVal = max(maxVal, grid[i][j + 1]);
                maxVal = max(maxVal, grid[i + 1][j - 1]);
                maxVal = max(maxVal, grid[i + 1][j]);
                maxVal = max(maxVal, grid[i + 1][j + 1]);
                maxLocal[i - 1][j - 1] = maxVal;
            }
        }
        return maxLocal;
    }
};