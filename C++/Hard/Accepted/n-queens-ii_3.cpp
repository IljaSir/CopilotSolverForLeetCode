class Solution {
public:
    int totalNQueens(int n) {
        
        vector<int> board(n, -1);
        int cnt = 0;
        dfs(board, 0, cnt);
        return cnt;
    }
    
    void dfs(vector<int>& board, int row, int& cnt) {
        if (row == board.size()) {
            ++cnt;
            return;
        }
        for (int col = 0; col < board.size(); ++col) {
            if (isValid(board, row, col)) {
                board[row] = col;
                dfs(board, row + 1, cnt);
                board[row] = -1;
            }
        }
    }
    
    bool isValid(vector<int>& board, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (board[i] == col || abs(row - i) == abs(col - board[i])) {
                return false;
            }
        }
        return true;
    }
};