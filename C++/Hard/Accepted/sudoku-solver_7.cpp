class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        
        int row = board.size();
        int col = board[0].size();
        solve(board, row, col);
    }
    bool solve(vector<vector<char>>& board, int row, int col) {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= 9; ++k) {
                        board[i][j] = '0' + k;
                        if (isValid(board, i, j) && solve(board, row, col)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    bool isValid(vector<vector<char>>& board, int row, int col) {
        for (int i = 0; i < 9; ++i) {
            if (i != row && board[i][col] == board[row][col]) {
                return false;
            }
        }
        for (int i = 0; i < 9; ++i) {
            if (i != col && board[row][i] == board[row][col]) {
                return false;
            }
        }
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if ((startRow + i != row || startCol + j != col) && board[startRow + i][startCol + j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
};