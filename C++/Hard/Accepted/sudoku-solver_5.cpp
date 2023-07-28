class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        
        solve(board, 0, 0);
    }
    bool solve(vector<vector<char>>& board, int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j == 9) {
            return solve(board, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return solve(board, i, j + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (solve(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }
    bool isValid(vector<vector<char>>& board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) {
                return false;
            }
            if (board[k][j] == c) {
                return false;
            }
            if (board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c) {
                return false;
            }
        }
        return true;
    }
};