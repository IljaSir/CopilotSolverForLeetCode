class Solution {
    public int countBattleships(char[][] board) {
        
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    mark(board, i, j);
                }
            }
        }
        return count;
    }
    public void mark(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        mark(board, i + 1, j);
        mark(board, i - 1, j);
        mark(board, i, j + 1);
        mark(board, i, j - 1);
    }
}