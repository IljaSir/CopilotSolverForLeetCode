class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        
        solve(board);
    }
    bool solve(vector<vector<char>>& board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    board[i][j] = '0' + k;
                    if (isValid(board, i, j) && solve(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }
    bool isValid(vector<vector<char>>& board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j]) {
                return false;
            }
            if (k != j && board[i][k] == board[i][j]) {
                return false;
            }
            int row = 3 * (i / 3) + k / 3;
            int col = 3 * (j / 3) + k % 3;
            if (row != i && col != j && board[row][col] == board[i][j]) {
                return false;
            }
        }
        return true;
    }
};