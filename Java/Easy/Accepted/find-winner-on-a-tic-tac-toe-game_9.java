class Solution {
    public String tictactoe(int[][] moves) {
        
        int n = moves.length;
        int[][] board = new int[3][3];
        int[][][] win = new int[8][3][2];
        win[0] = new int[][]{{0, 0}, {0, 1}, {0, 2}};
        win[1] = new int[][]{{1, 0}, {1, 1}, {1, 2}};
        win[2] = new int[][]{{2, 0}, {2, 1}, {2, 2}};
        win[3] = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        win[4] = new int[][]{{0, 1}, {1, 1}, {2, 1}};
        win[5] = new int[][]{{0, 2}, {1, 2}, {2, 2}};
        win[6] = new int[][]{{0, 0}, {1, 1}, {2, 2}};
        win[7] = new int[][]{{0, 2}, {1, 1}, {2, 0}};
        for (int i = 0; i < n; i++) {
            board[moves[i][0]][moves[i][1]] = i % 2 == 0 ? 1 : 2;
        }
        for (int i = 0; i < 8; i++) {
            int a = board[win[i][0][0]][win[i][0][1]];
            int b = board[win[i][1][0]][win[i][1][1]];
            int c = board[win[i][2][0]][win[i][2][1]];
            if (a == b && a == c && a != 0) {
                return a == 1 ? "A" : "B";
            }
        }
        if (n == 9) {
            return "Draw";
        }
        return "Pending";
    }
}