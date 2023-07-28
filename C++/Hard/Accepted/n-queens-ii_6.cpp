class Solution {
public:
    int totalNQueens(int n) {
        
        int count = 0;
        vector<int> board(n, 0);
        backtrack(board, 0, count);
        return count;
    }

    void backtrack(vector<int>& board, int row, int& count) {
        if (row == board.size()) {
            count++;
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (isValid(board, row, col)) {
                board[row] = col;
                backtrack(board, row + 1, count);
            }
        }
    }

    bool isValid(vector<int>& board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || abs(board[i] - col) == abs(i - row)) {
                return false;
            }
        }
        return true;
    }
};