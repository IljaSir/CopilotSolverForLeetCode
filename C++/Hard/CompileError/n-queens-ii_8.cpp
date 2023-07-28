class Solution {
public:
    int totalNQueens(int n) {
        
        int board[n][n];
        memset(board, 0, sizeof(board));
        int count = 0;
        solve(board, 0, n, count);
        return count;
    }
    
    bool isSafe(int board[][10], int row, int col, int n) {
        // check in left side
        for(int i = 0; i < col; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }
        
        // check in upper diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        
        // check in lower diagonal
        for(int i = row, j = col; i < n && j >= 0; i++, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    
    void solve(int board[][10], int col, int n, int &count) {
        if(col == n) {
            count++;
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(isSafe(board, i, col, n)) {
                board[i][col] = 1;
                solve(board, col + 1, n, count);
                board[i][col] = 0;
            }
        }
    }
};