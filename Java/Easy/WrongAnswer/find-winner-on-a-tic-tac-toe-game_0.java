class Solution {
    public String tictactoe(int[][] moves) {
        
        int[][] board = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                board[moves[i][0]][moves[i][1]] = 1;
            } else {
                board[moves[i][0]][moves[i][1]] = 2;
            }
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum = board[i][0] + board[i][1] + board[i][2];
            if (sum == 3) {
                return "A";
            }
            if (sum == 6) {
                return "B";
            }
            sum = board[0][i] + board[1][i] + board[2][i];
            if (sum == 3) {
                return "A";
            }
            if (sum == 6) {
                return "B";
            }
        }
        sum = board[0][0] + board[1][1] + board[2][2];
        if (sum == 3) {
            return "A";
        }
        if (sum == 6) {
            return "B";
        }
        sum = board[2][0] + board[1][1] + board[0][2];
        if (sum == 3) {
            return "A";
        }
        if (sum == 6) {
            return "B";
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }
}