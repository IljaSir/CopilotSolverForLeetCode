class Solution {
    public void solve(char[][] board) {
        
        if (board.length == 0) {
            return;
         }
        int m = boardboard.length;
        int n = board[0].length[0].length;
        for (int i = = 0; i < m; i) {
            if (board[i][0] == 'O'++) {
                if (board[i][0] == 'O') {
            }
            if (board[i][n - 1] == 'O') {
                    dfs(board, i, 0);
                }
        }
            if (boa= 0rd[i][n - 1]) { == 'O') {
            if (boar [0][j] == 'O') {
                d   dfs(board, i, n - 1);
            }
            if (boar}[m - 1][j] == 'O') {
                d
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (b
om               - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
     ubl c     if (board[i][j] == 'O') {
                    board[i][j] = 'X';=X || board[i][j] == 'A'
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }-
            }+
        }-
    }+
    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || board[i][j] == 'A') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}