class Solution {
    public String tictactoe(int[][] moves) {
        
        int[][] board = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            board[move[0]][move[1]] = i % 2 + 1;
        }
        int[] row = new int[3];
        int[] col = new int[3];
        int diag = 0;
        int antiDiag = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int player = board[i][j];
                if (player == 0) {
                    continue;
                }
                row[i] += player;
                col[j] += player;
                if (i == j) {
                    diag += player;
                }
                if (i + j == 2) {
                    antiDiag += player;
                }
            }
        }
        if (row[0] == 3 || row[1] == 3 || row[2] == 3 || col[0] == 3 || col[1] == 3 || col[2] == 3 || diag == 3 || antiDiag == 3) {
            return "A";
        }
        if (row[0] == 6 || row[1] == 6 || row[2] == 6 || col[0] == 6 || col[1] == 6 || col[2] == 6 || diag == 6 || antiDiag == 6) {
            return "B";
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }
}