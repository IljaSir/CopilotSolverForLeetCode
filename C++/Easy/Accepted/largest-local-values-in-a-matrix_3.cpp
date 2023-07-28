class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        
        int n = grid.size();
        vector<vector<int>> maxLocal(n - 2, vector<int>(n - 2));
        for (int i = 1; i < n - 1; i++)
            for (int j = 1; j < n - 1; j++) {
                maxLocal[i - 1][j - 1] = grid[i - 1][j - 1];
                maxLocal[i - 1][j - 1] = max(maxLocal[i - 1][j - 1], grid[i - 1][j]);
                maxLocal[i - 1][j - 1] = max(maxLocal[i - 1][j - 1], grid[i - 1][j + 1]);
                maxLocal[i - 1][j - 1] = max(maxLocal[i - 1][j - 1], grid[i][j - 1]);
                maxLocal[i - 1][j - 1] = max(maxLocal[i - 1][j - 1], grid[i][j]);
                maxLocal[i - 1][j - 1] = max(maxLocal[i - 1][j - 1], grid[i][j + 1]);
                maxLocal[i - 1][j - 1] = max(maxLocal[i - 1][j - 1], grid[i + 1][j - 1]);
                maxLocal[i - 1][j - 1] = max(maxLocal[i - 1][j - 1], grid[i + 1][j]);
                maxLocal[i - 1][j - 1] = max(maxLocal[i - 1][j - 1], grid[i + 1][j + 1]);
            }
        return maxLocal;
    }
};