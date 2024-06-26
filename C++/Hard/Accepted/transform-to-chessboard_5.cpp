class Solution {
public:
    int movesToChessboard(vector<vector<int>>& board) {
        
        int n = board.size();
        int rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[0][j] ^ board[i][0] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            rowSum += board[0][i];
            colSum += board[i][0];
            rowSwap += board[i][0] == (i % 2);
            colSwap += board[0][i] == (i % 2);
        }
        if (rowSum < n / 2 || rowSum > (n + 1) / 2) {
            return -1;
        }
        if (colSum < n / 2 || colSum > (n + 1) / 2) {
            return -1;
        }
        if (n % 2 == 1) {
            if (colSwap % 2 == 1) {
                colSwap = n - colSwap;
            }
            if (rowSwap % 2 == 1) {
                rowSwap = n - rowSwap;
            }
        } else {
            colSwap = min(n - colSwap, colSwap);
            rowSwap = min(n - rowSwap, rowSwap);
        }
        return (colSwap + rowSwap) / 2;
    }
};