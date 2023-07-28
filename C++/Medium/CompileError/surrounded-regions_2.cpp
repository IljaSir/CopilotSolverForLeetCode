class Solution {
public:
    void solve(vector<vector<char>>& board) {
        
        int m = board.size();
        if (m == 0) return;
        int n = board[0].size();
        if (n == 0) return;
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, visited, i, 0);
            }
            if (board[i][n-1] == 'O') {
                dfs(board, visited, i, n-1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, visited, 0, j);
            }
            if (board[m-1][j] == 'O') {
                dfs(board, visited, m-1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
};