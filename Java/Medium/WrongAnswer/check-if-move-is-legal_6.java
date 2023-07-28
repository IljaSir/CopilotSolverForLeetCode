class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        int[][] dirs = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
        for (int[] dir : dirs) {
            int x = rMove + dir[0], y = cMove + dir[1];
            int count = 0;
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == color) {
                    count++;
                    break;
                } else if (board[x][y] == '.') {
                    break;
                }
                x += dir[0];
                y += dir[1];
            }
            x = rMove - dir[0];
            y = cMove - dir[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == color) {
                    count++;
                    break;
                } else if (board[x][y] == '.') {
                    break;
                }
                x -= dir[0];
                y -= dir[1];
            }
            if (count == 2) {
                return true;
            }
        }
        return false;
    }
}