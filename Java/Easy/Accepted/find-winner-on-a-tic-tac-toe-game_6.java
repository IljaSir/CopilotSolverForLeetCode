class Solution {
    public String tictactoe(int[][] moves) {
        
        int[][] grid = new int[3][3];
        int player = 1;
        for (int[] move : moves) {
            grid[move[0]][move[1]] = player;
            player = -player;
        }
        int[] sumRow = new int[3];
        int[] sumCol = new int[3];
        int sumDiag = 0;
        int sumAntiDiag = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sumRow[i] += grid[i][j];
                sumCol[j] += grid[i][j];
                if (i == j) {
                    sumDiag += grid[i][j];
                }
                if (i + j == 2) {
                    sumAntiDiag += grid[i][j];
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (sumRow[i] == 3 || sumCol[i] == 3) {
                return "A";
            }
            if (sumRow[i] == -3 || sumCol[i] == -3) {
                return "B";
            }
        }
        if (sumDiag == 3 || sumAntiDiag == 3) {
            return "A";
        }
        if (sumDiag == -3 || sumAntiDiag == -3) {
            return "B";
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }
}