class Solution {
public:
    int maxProductPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> maxProd(m, vector<int>(n, 0));
        vector<vector<int>> minProd(m, vector<int>(n, 0));
        maxProd[0][0] = minProd[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) {
            maxProd[i][0] = maxProd[i - 1][0] * grid[i][0];
            minProd[i][0] = minProd[i - 1][0] * grid[i][0];
        }
        for (int j = 1; j < n; ++j) {
            maxProd[0][j] = maxProd[0][j - 1] * grid[0][j];
            minProd[0][j] = minProd[0][j - 1] * grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (grid[i][j] > 0) {
                    maxProd[i][j] = max(maxProd[i - 1][j], maxProd[i][j - 1]) * grid[i][j];
                    minProd[i][j] = min(minProd[i - 1][j], minProd[i][j - 1]) * grid[i][j];
                } else {
                    maxProd[i][j] = min(minProd[i - 1][j], minProd[i][j - 1]) * grid[i][j];
                    minProd[i][j] = max(maxProd[i - 1][j], maxProd[i][j - 1]) * grid[i][j];
                }
            }
        }
        return maxProd[m - 1][n - 1] < 0 ? -1 : maxProd[m - 1][n - 1] % 1000000007;
    }
};