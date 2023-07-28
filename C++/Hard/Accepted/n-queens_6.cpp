class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        
        vector<vector<string>> result;
        vector<string> board(n, string(n, '.'));
        solveNQueens(0, board, result);
        return result;
    }
    
    void solveNQueens(int row, vector<string>& board, vector<vector<string>>& result) {
        if (row == board.size()) {
            result.push_back(board);
            return;
        }
        for (int col = 0; col < board.size(); ++col) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueens(row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }
    
    bool isValid(vector<string>& board, int row, int col) {
        for (int i = 0; i < board.size(); ++i) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); --i, ++j) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
};