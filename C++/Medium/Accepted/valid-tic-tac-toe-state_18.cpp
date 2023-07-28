class Solution {
public:
    bool validTicTacToe(vector<string>& board) {
        
        int countX = 0, countO = 0;
        for (auto& row : board) {
            for (auto& c : row) {
                if (c == 'X') countX++;
                if (c == 'O') countO++;
            }
        }
        if (countX < countO || countX > countO + 1) return false;
        bool winX = win(board, 'X');
        bool winO = win(board, 'O');
        if (winX && winO) return false;
        if (winX && countX == countO) return false;
        if (winO && countX > countO) return false;
        return true;
    }
    
    bool win(vector<string>& board, char c) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == c && board[i][1] == c && board[i][2] == c) return true;
            if (board[0][i] == c && board[1][i] == c && board[2][i] == c) return true;
        }
        if (board[0][0] == c && board[1][1] == c && board[2][2] == c) return true;
        if (board[0][2] == c && board[1][1] == c && board[2][0] == c) return true;
        return false;
    }
};