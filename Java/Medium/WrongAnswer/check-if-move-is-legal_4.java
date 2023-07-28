class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
        for (int i = 0; i < 8; i++) {
            int x = rMove, y = cMove;
            int count = 0;
            while (x >= 0 && y >= 0 && x < 8 && y < 8) {
                if (board[x][y] == color) {
                    break;
                }
                if (board[x][y] == '.') {
                    count = 0;
                    break;
                }
                count++;
                x += dx[i];
                y += dy[i];
            }
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }
}