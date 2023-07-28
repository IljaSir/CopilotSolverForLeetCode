class Solution {
public:
    void solve(vector<vector<char>>& board) {
        
        int row = board.size();
        if (row == 0) return;
        int col = board[0].size();
        if (col == 0) return;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][col-1] == 'O') dfs(board, i, col-1);
        }
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[row-1][j] == 'O') dfs(board, row-1, j);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'Q') board[i][j] = 'O';
            }
        }
    }
};