class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
        for (int i = 0; i < 8; i++) {
            int x = rMove + dx[i];
            int y = cMove + dy[i];
            int count = 0;
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
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
            if (count >= 2) {
                return true;
            }
        }
        return false;
    }
}