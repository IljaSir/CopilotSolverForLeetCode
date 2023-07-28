class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        int[][] d = new int[][]{{-1,0},{1,0},{0,-1},{0,1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for (int i = 0; i < 8; i++) {
            int x = rMove + d[i][0], y = cMove + d[i][1];
            if (x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] != '.' && board[x][y] != color) {
                int cnt = 0;
                while (x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] != '.') {
                    if (board[x][y] == color) {
                        cnt++;
                    }
                    x += d[i][0];
                    y += d[i][1];
                }
                if (cnt >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}