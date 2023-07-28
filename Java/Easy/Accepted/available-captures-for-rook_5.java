class Solution {
    public int numRookCaptures(char[][] board) {
        
        int row = 0;
        int col = 0;
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        res += count(board, row, col, 0, 1);
        res += count(board, row, col, 0, -1);
        res += count(board, row, col, 1, 0);
        res += count(board, row, col, -1, 0);
        return res;
    }
    public int count(char[][] board, int row, int col, int rowDir, int colDir) {
        while (row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] != 'B') {
            if (board[row][col] == 'p') {
                return 1;
            }
            row += rowDir;
            col += colDir;
        }
        return 0;
    }
}