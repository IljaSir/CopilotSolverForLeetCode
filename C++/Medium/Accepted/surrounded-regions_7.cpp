class Solution {
public:
    void solve(vector<vector<char>>& board) {
        
        int m = board.size();
        int n = board[0].size();
        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(vector<vector<char>>& board, int i, int j) {
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size()) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'M';
        }
        if (i > 0 && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);
        }
        if (i < board.size() - 1 && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);
        }
        if (j > 0 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }
        if (j < board[0].size() - 1 && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }
    }
};