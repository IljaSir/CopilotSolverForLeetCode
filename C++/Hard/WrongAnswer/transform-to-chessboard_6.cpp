class Solution {
public:
    int movesToChessboard(vector<vector<int>>& board) {
        
        int n = board.size();
        int row0 = 0, row1 = 0, col0 = 0, col1 = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            row0 += board[0][i] == i % 2;
            row1 += board[0][i] == (i + 1) % 2;
            col0 += board[i][0] == i % 2;
            col1 += board[i][0] == (i + 1) % 2;
        }
        if (n / 2 > row0 || row0 > (n + 1) / 2) {
            return -1;
        }
        if (n / 2 > row1 || row1 > (n + 1) / 2) {
            return -1;
        }
        if (n / 2 > col0 || col0 > (n + 1) / 2) {
            return -1;
        }
        if (n / 2 > col1 || col1 > (n + 1) / 2) {
            return -1;
        }
        if (n % 2) {
            if (col0 % 2) {
                col0 = n - col0;
            }
            if (row0 % 2) {
                row0 = n - row0;
            }
        } else {
            col0 = min(n - col0, col0);
            row0 = min(n - row0, row0);
        }
        return (col0 + row0) / 2;
    }
};