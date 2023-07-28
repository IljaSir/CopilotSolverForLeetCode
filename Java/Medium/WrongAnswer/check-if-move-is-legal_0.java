class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < 8; i++) {
            int nr = rMove + dr[i], nc = cMove + dc[i];
            if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8 && board[nr][nc] != color && board[nr][nc] != '.') {
                int count = 0;
                while (nr >= 0 && nr < 8 && nc >= 0 && nc < 8 && board[nr][nc] != '.') {
                    if (board[nr][nc] == color) {
                        count++;
                    }
                    nr += dr[i];
                    nc += dc[i];
                }
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}