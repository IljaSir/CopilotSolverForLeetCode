class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        
        int x = 0, o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') x++;
                else if (board[i][j] == 'O') o++;
            }
        }
        if (o > x || x - o > 1) return false;
        bool winX = win(board, 'X');
        bool winO = win(board, 'O');
        if (winX && winO) return false;
        if (winX && o == x) return false;
        if (winO && o < x) return false;
        return true;
    }
    
    bool win(vector<string>& board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }
};