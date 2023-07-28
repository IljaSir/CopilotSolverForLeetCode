class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        
        int x = 0, o = 0;
        for (string row : board) {
            for (char c : row) {
                if (c == 'X') {
                    x++;
                } else if (c == 'O') {
                    o++;
                }
            }
        }
        if (o > x || x - o > 1) {
            return false;
        }
        if (win(board, 'X') && o == x) {
            return false;
        }
        if (win(board, 'O') && o < x) {
            return false;
        }
        return true;
    }
    bool win(vector<string>& board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
};