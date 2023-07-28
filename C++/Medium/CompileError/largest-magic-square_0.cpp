class Solution {
public:
    int largestMagicSquare(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> rowSum(m, vector<int>(n, 0));
        vector<vector<int>> colSum(m, vector<int>(n, 0));
        vector<vector<int>> diaSum1(m, vector<int>(n, 0));
        vector<vector<int>> diaSum2(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            rowSum[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            colSum[0][j] = grid[0][j];
            for (int i = 1; i < m; i++) {
                colSum[i][j] = colSum[i - 1][j] + grid[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            diaSum1[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                if (i + j < m) {
                    diaSum1[i + j][j] = diaSum1[i + j - 1][j - 1] + grid[i + j][j];
                }
                if (i - j >= 0) {
                    diaSum2[i - j][j] = diaSum2[i - j + 1][j - 1] + grid[i - j][j];
                }
            }
        }
        for (int j = 1; j < n; j++) {
            diaSum1[0][j] = grid[0][j];
            for (int i = 1; i < m; i++) {
                if (i + j < n) {
                    diaSum1[i][i + j] = diaSum1[i - 1][i + j - 1] + grid[i][i + j];
                }
                if (j - i >= 0) {
                    diaSum2[i][j - i] = diaSum2[i - 1
    }
};