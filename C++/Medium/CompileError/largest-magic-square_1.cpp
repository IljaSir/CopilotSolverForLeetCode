class Solution {
public:
    int largestMagicSquare(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> rowSum(m, vector<int>(n, 0));
        vector<vector<int>> colSum(m, vector<int>(n, 0));
        vector<vector<int>> diagSum(m, vector<int>(n, 0));
        vector<vector<int>> antiDiagSum(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j] = grid[i][j] + (j > 0 ? rowSum[i][j - 1] : 0);
                colSum[i][j] = grid[i][j] + (i > 0 ? colSum[i - 1][j] : 0);
                diagSum[i][j] = grid[i][j] + (i > 0 && j > 0 ? diagSum[i - 1][j - 1] : 0);
                antiDiagSum[i][j] = grid[i][j] + (i > 0 && j < n - 1 ? antiDiagSum[i - 1][j + 1] : 0);
            }
        }
        int res = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; i + k < m && j + k < n; k++) {
                    int row = rowSum[i][j + k] - (j > 0 ? rowSum[i][j - 1] : 0);
                    int col = colSum[i + k][j] - (i > 0 ? colSum[i - 1][j] : 0);
                    int diag = diagSum[i + k][j + k] - (i > 0 && j > 0 ? diagSum[i - 1][j - 1] : 0);
                    int antiDiag = antiDiagSum[i + k][j] - (i > 0 && j + k < n - 1 ? antiDiagSum[i - 1][j + k + 1] : 0);
                    if (
    }
};