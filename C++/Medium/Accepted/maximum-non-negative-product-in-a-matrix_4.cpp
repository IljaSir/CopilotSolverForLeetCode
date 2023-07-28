class Solution {
public:
    int maxProductPath(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<long long>> maxProd(m, vector<long long>(n, 0));
        vector<vector<long long>> minProd(m, vector<long long>(n, 0));
        maxProd[0][0] = minProd[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            maxProd[i][0] = maxProd[i-1][0]*grid[i][0];
            minProd[i][0] = minProd[i-1][0]*grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            maxProd[0][i] = maxProd[0][i-1]*grid[0][i];
            minProd[0][i] = minProd[0][i-1]*grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long long maxVal = max(max(maxProd[i-1][j]*grid[i][j], maxProd[i][j-1]*grid[i][j]),
                                       max(minProd[i-1][j]*grid[i][j], minProd[i][j-1]*grid[i][j]));
                long long minVal = min(min(maxProd[i-1][j]*grid[i][j], maxProd[i][j-1]*grid[i][j]),
                                       min(minProd[i-1][j]*grid[i][j], minProd[i][j-1]*grid[i][j]));
                maxProd[i][j] = maxVal;
                minProd[i][j] = minVal;
            }
        }
        long long res = maxProd[m-1][n-1];
        if (res < 0) {
            return -1;
        }
        return res % 1000000007;
    }
};