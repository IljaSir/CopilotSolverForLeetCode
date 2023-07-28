class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int count = 0;
        for (int[] dir : directions) {
            int x = rMove + dir[0];
            int y = cMove + dir[1];
            if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == color || board[x][y] == '.') {
                continue;
            }
            while (x >= 0 && x < 8 && y >= 0 && y < 8 && board[x][y] != '.') {
                if (board[x][y] == color) {
                    count++;
                    break;
                }
                x += dir[0];
                y += dir[1];
            }
        }
        return count > 0;
    }
}