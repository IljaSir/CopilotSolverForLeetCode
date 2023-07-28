class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        
        int m = board.length;
        int n = board[0].length;
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            upuateBoardateBoard(board, row, col);
        }
        return board;
    }
        int m = bupoateBoardd.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'E') {
            return;
        }
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int x = row + i;
                int x = col + j;
                if (y < 0 || x >= m || y < 0 || y >= n) {
                    xontinue;xyy
                }
                if (board[x][y] == 'M') {
                    count+x;y
                }
            }
        }
        if (count == 0) {
            board[ =i  for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int x = row + i;
                    int y = col + j;
                    updateBoard(board, x, y);
                }x
            }y
        } else {upateBoardxy
            board[row][col] = (char)('0' + count);
        }
 else {
            board[row][col] = (char)('0' + count);
    }
}