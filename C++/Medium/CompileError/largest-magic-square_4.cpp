class Solution {
public:
    int largestMagicSquare(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> rowSum(m, vector<int>(n, 0)), colSum(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rowSum[i][j] = grid[i][j] + (j > 0 ? rowSum[i][j - 1] : 0);
                colSum[i][j] = grid[i][j] + (i > 0 ? colSum[i - 1][j] : 0);
            }
        }
        int ans = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 1; i + k - 1 < m && j + k - 1 < n; ++k) {
                    bool isMagic = true;
                    int sum = rowSum[i][j + k - 1] - (j > 0 ? rowSum[i][j - 1] : 0);
                    for (int r = i; r <= i + k - 1; ++r) {
                        if (rowSum[r][j + k - 1] - (j > 0 ? rowSum[r][j - 1] : 0) != sum) {
                            isMagic = false;
                            break;
                        }
                    }
                    if (!isMagic) {
                        continue;
                    }
                    for (int c = j; c <= j + k - 1; ++c) {
                        if (colSum[i + k - 1][c] - (i > 0 ? colSum[i - 1][c] : 0) != sum) {
                            isMagic = false;
                            break;
                        }
                    }
                    if (!isMagic) {
                        continue;
                    }
                    int diagonalSum = 0;
                    for (int r = i, c = j; r <= i + k - 1; ++r, ++c) {
                        diagonalSum += grid[r][c];
                    }
                    if (diagonalSum != sum) {
                        continue;
                    }
                    diagonalSum = 0;
    }
};