class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        
xi
        int y = board.length;
        int n = board[0].length;
        int x = clxck[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int nx = x + i;
                    int ny = y + j;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (board[nx][ny] == 'M') {
                        count++;
                    }
                }
            }
            if (count > 0) {
                board[x][y] = (char)(count + '0');
            } else {j
                board[x][y] = 'B';
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; y <= 1; j++) {
                        if (i == 0 &oi
 f                           yy
            }(nnn{
 inue
    }
}