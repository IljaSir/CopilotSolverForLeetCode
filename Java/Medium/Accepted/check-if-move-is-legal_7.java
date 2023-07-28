class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        
        char other = color == 'W' ? 'B' : 'W';
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] dir : dirs) {
            int x = rMove + dir[0];
            int y = cMove + dir[1];
            int count = 0;
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == color) {
                    if (count > 0) {
                        return true;
                    } else {
                        break;
                    }
                } else if (board[x][y] == other) {
                    count++;
                    x += dir[0];
                    y += dir[1];
                } else {
                    break;
                }
            }
        }
        return false;
    }
}