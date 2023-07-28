class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        
        int n = board.size();
        int x = 0, o = 0;
        int row = 0, col = 0, diag = 0, antiDiag = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    x++;
                    row = (row << 1) | 1;
                    col = (col << 1) | 1;
                    if (i == j) {
                        diag = (diag << 1) | 1;
                    }
                    if (i + j == n - 1) {
                        antiDiag = (antiDiag << 1) | 1;
                    }
                } else if (board[i][j] == 'O') {
                    o++;
                    row = row << 1;
                    col = col << 1;
                    if (i == j) {
                        diag = diag << 1;
                    }
                    if (i + j == n - 1) {
                        antiDiag = antiDiag << 1;
                    }
                } else {
                    row = row << 1;
                    col = col << 1;
                    if (i == j) {
                        diag = diag << 1;
                    }
                    if (i + j == n - 1) {
                        antiDiag = antiDiag << 1;
                    }
                }
            }
        }
        if (x == o) {
            if (row == 0b111 || col == 0b111 || diag == 0b111 || antiDiag == 0b111) {
                return false;
            }
        } else if (x == o + 1) {
            if (row == 0b111000 || col == 0b111000 || diag == 0b111000 || antiDiag == 0b111000) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
};