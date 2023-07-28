class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for (int[] direction : directions) {
            int count = 0;
            int x = rMove;
            int y = cMove;
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == color) {
                    if (count > 1) {
                        return true;
                    }
                    break;
                }
                if (board[x][y] == '.') {
                    break;
                }
                count++;
                x += direction[0];
                y += direction[1];
            }
        }
        return false;
    }
}