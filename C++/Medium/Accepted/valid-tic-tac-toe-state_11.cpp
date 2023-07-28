class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        
        int x = 0;
        int o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    x++;
                } else if (board[i][j] == 'O') {
                    o++;
                }
            }
        }
        if (o > x || x > o + 1) {
            return false;
        }
        if (win(board, 'X') && x == o) {
            return false;
        }
        if (win(board, 'O') && x > o) {
            return false;
        }
        return true;
    }
    bool win(vector<string>& board, char c) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) {
                return true;
            }
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c) {
                return true;
            }
        }
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
            return true;
        }
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) {
            return true;
        }
        return false;
    }
};