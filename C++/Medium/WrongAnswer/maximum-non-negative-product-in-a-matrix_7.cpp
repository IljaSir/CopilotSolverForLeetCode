class Solution {
public:
    int maxProductPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<long long>> maxGrid(m, vector<long long>(n, 0));
        vector<vector<long long>> minGrid(m, vector<long long>(n, 0));
        maxGrid[0][0] = grid[0][0];
        minGrid[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            maxGrid[i][0] = maxGrid[i - 1][0] * grid[i][0];
            minGrid[i][0] = minGrid[i - 1][0] * grid[i][0];
        }
        
        for (int i = 1; i < n; i++) {
            maxGrid[0][i] = maxGrid[0][i - 1] * grid[0][i];
            minGrid[0][i] = minGrid[0][i - 1] * grid[0][i];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                maxGrid[i][j] = max(maxGrid[i - 1][j] * grid[i][j], maxGrid[i][j - 1] * grid[i][j]);
                minGrid[i][j] = min(minGrid[i - 1][j] * grid[i][j], minGrid[i][j - 1] * grid[i][j]);
            }
        }
        
        return maxGrid[m - 1][n - 1] < 0 ? -1 : maxGrid[m - 1][n - 1] % 1000000007;
    }
};