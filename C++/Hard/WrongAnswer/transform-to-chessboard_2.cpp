class Solution {
public:
    int movesToChessboard(vector<vector<int>>& board) {
        
        int n = board.size();
        vector<int> row(n), col(n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                row[i] = (row[i] << 1) | board[i][j];
                col[j] = (col[j] << 1) | board[i][j];
            }
        }
        int rowSum = accumulate(row.begin(), row.end(), 0);
        int colSum = accumulate(col.begin(), col.end(), 0);
        if (rowSum < n / 2 || rowSum > (n + 1) / 2) {
            return -1;
        }
        if (colSum < n / 2 || colSum > (n + 1) / 2) {
            return -1;
        }
        int rowDiff = 0;
        for (int i = 0; i < n; ++i) {
            if (row[i] != (i % 2 ? row[0] : (row[0] ^ ((1 << n) - 1)))) {
                rowDiff++;
            }
        }
        int colDiff = 0;
        for (int j = 0; j < n; ++j) {
            if (col[j] != (j % 2 ? col[0] : (col[0] ^ ((1 << n) - 1)))) {
                colDiff++;
            }
        }
        if (n % 2 == 1) {
            if (rowDiff % 2 == 1) {
                rowDiff = n - rowDiff;
            }
            if (colDiff % 2 == 1) {
                colDiff = n - colDiff;
            }
        }
        else {
            rowDiff = min(n - rowDiff, rowDiff);
            colDiff = min(n - colDiff, colDiff);
        }
        return (rowDiff + colDiff) / 2;
    }
};