class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    xCount++;
                } else if (board[i][j] == 'O') {
                    oCount++;
                }
            }
        }
        if (oCount > xCount || xCount - oCount > 1) {
            return false;
        }
        bool xWin = false;
        bool oWin = false;
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != ' ') {
                if (board[i][0] == 'X') {
                    xWin = true;
                } else {
                    oWin = true;
                }
            }
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != ' ') {
                if (board[0][i] == 'X') {
                    xWin = true;
                } else {
                    oWin = true;
                }
            }
        }
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ') {
            if (board[0][0] == 'X') {
                xWin = true;
            } else {
                oWin = true;
            }
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' ') {
            if (board[0][2] == 'X') {
                xWin = true;
            } else {
                oWin = true;
            }
        }
        if (xWin && oWin) {
            return false;
        }
        if (xWin && oCount == xCount) {
            return false;
        }
        if (oWin && oCount != xCount) {
            return false;
        }
    }
};