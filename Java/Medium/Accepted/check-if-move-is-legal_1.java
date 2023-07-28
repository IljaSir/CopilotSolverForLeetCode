class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < 8; ++i) {
            int nr = rMove + dr[i];
            int nc = cMove + dc[i];
            int count = 0;
            while (nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
                if (board[nr][nc] == color) {
                    if (count >= 1) {
                        return true;
                    }
                    break;
                } else if (board[nr][nc] == '.') {
                    break;
                }
                nr += dr[i];
                nc += dc[i];
                count++;
            }
        }
        return false;
    }
}