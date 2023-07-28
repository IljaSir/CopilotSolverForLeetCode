class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length, n = board[0].length;
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] & 1) == 1) {
                        live++;
                    }
                }
                if (live == 3 || live + (board[i][j] & 1) == 3) {
                    board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}