class Solution {
public:
    int totalNQueens(int n) {
        
        vector<vector<string>> ans;
        vector<string> board(n, string(n, '.'));
        backtrack(ans, board, 0);
        return ans.size();
    }
    void backtrack(vector<vector<string>>& ans, vector<string>& board, int row) {
        if (row == board.size()) {
            ans.push_back(board);
            return;
        }
        int n = board[row].size();
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(ans, board, row + 1);
            board[row][col] = '.';
        }
    }
    bool isValid(vector<string>& board, int row, int col) {
        int n = board.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Q' && (col == j || row + col == i + j || row - col == i - j)) {
                    return false;
                }
            }
        }
        return true;
    }
};