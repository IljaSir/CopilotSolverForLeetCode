class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        
        int x = 0;
        int o = 0;
        for (auto& row : board) {
            for (auto& ch : row) {
                if (ch == 'X') x++;
                if (ch == 'O') o++;
            }
        }
        if (x != o && x != o + 1) return false;
        
        bool xwin = win(board, 'X');
        bool owin = win(board, 'O');
        
        if (xwin && owin) return false;
        if (xwin && x == o) return false;
        if (owin && x > o) return false;
        
        return true;
    }
    
    bool win(vector<string>& board, char ch) {
        // check rows
        for (auto& row : board) {
            if (row[0] == ch && row[1] == ch && row[2] == ch) return true;
        }
        // check cols
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == ch && board[1][j] == ch && board[2][j] == ch) return true;
        }
        // check diagonals
        if (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) return true;
        if (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch) return true;
        return false;
    }
};