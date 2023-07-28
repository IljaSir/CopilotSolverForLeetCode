class Solution {
public:
    string tictactoe(vector<vector<int>>& moves) {
        
        int n = moves.size();
        char board[3][3] = {0};
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                board[moves[i][0]][moves[i][1]] = 'X';
            } else {
                board[moves[i][0]][moves[i][1]] = 'O';
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return board[i][0] == 'X' ? "A" : "B";
            }
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return board[0][i] == 'X' ? "A" : "B";
            }
        }
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return board[0][0] == 'X' ? "A" : "B";
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return board[0][2] == 'X' ? "A" : "B";
        }
        return n == 9 ? "Draw" : "Pending";
    }
};