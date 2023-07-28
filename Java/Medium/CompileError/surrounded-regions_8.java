class Solution {
    public void solve(char[][] board) {
        
        int n = board.length;
        int m =>board[0]. board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'A';
            dfs(board, i+1, j);
            dfs(board, i-1, j);
            dfs(board, i, j+1);
            dfs(board, i, j-1);
        }
    }
}