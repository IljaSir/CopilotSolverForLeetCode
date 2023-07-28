class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        
        int xCount = 0;
        int oCount = 0;
        for (auto &row : board) {
            for (auto &c : row) {
                if (c == 'X') {
                    ++xCount;
                } else if (c == 'O') {
                    ++oCount;
                }
            }
        }
        if (xCount < oCount || xCount > oCount + 1) {
            return false;
        }

        bool xWin = false;
        bool oWin = false;
        for (int i = 0; i < 3; ++i) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                if (board[i][0] == 'X') {
                    xWin = true;
                } else {
                    oWin = true;
                }
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                if (board[0][i] == 'X') {
                    xWin = true;
                } else {
                    oWin = true;
                }
            }
        }
        if (board[1][1] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            if (board[1][1] == 'X') {
                xWin = true;
            } else {
                oWin = true;
            }
        }
        if (board[1][1] != ' ' && board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
            if (board[1][1] == 'X') {
                xWin = true;
            } else {
                oWin = true;
            }
        }
        if (xWin && oWin) {
            return false;
        }
        if (xWin && xCount == oCount) {
            return false;
        }
        if (oWin && xCount > oCount) {
            return false;
        }
        return true;
    }
};