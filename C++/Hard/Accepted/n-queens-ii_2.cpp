class Solution {
public:
    int totalNQueens(int n) {
        
        int res = 0;
        vector<int> board(n, -1);
        dfs(board, 0, res);
        return res;
    }
    
    void dfs(vector<int>& board, int row, int& res) {
        if (row == board.size()) {
            res++;
            return;
        }
        for (int col = 0; col < board.size(); col++) {
            if (isValid(board, row, col)) {
                board[row] = col;
                dfs(board, row + 1, res);
                board[row] = -1;
            }
        }
    }
    
    bool isValid(vector<int>& board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == board[i] || abs(col - board[i]) == abs(row - i)) {
                return false;
            }
        }
        return true;
    }
};