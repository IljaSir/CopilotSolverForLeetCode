class Solution {
public:
    int largestMagicSquare(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int res = 1;
        vector<vector<int>> rowSum(m, vector<int>(n, 0));
        vector<vector<int>> colSum(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j] = grid[i][j];
                if (j > 0) {
                    rowSum[i][j] += rowSum[i][j - 1];
                }
                colSum[i][j] = grid[i][j];
                if (i > 0) {
                    colSum[i][j] += colSum[i - 1][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = res; k <= min(m - i, n - j); k++) {
                    int sum = rowSum[i][j + k - 1];
                    if (j > 0) {
                        sum -= rowSum[i][j - 1];
                    }
                    int flag = 1;
                    for (int p = i; p < i + k; p++) {
                        int curSum = rowSum[p][j + k - 1];
                        if (j > 0) {
                            curSum -= rowSum[p][j - 1];
                        }
                        if (curSum != sum) {
                            flag = 0;
                            break;
                        }
                    }
                    if (!flag) {
                        continue;
                    }
                    for (int p = j; p < j + k; p++) {
                        int curSum = colSum[i + k - 1][p];
                        if (i > 0) {
                            curSum -= colSum[i - 1][p];
                        }
                        if (curSum != sum) {
                            flag = 0;
                            break;
                        }
                    }
                    if (!flag) {
                        continue;
                    }
                    int curSum = colSum[i + k - 1][j + k - 1];
                    if (i > 0 && j > 0) {
                        curSum -= colSum[i -
    }
};