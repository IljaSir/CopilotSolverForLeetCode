class Solution {
    public String tictactoe(int[][] moves) {
        
        char[][] board = new char[3][3];
        int n = moves.length;
        for (int i = 0; i < n; i++) {
            int row = moves[i][0];
            int col = moves[i][1];
            if (i % 2 == 0) {
                board[row][col] = 'X';
            } else {
                board[row][col] = 'O';
            }
        }
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += board[i][j];
            }
            if (sum == 'X' * 3) {
                return "A";
            }
            if (sum == 'O' * 3) {
                return "B";
            }
        }
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += board[j][i];
            }
            if (sum == 'X' * 3) {
                return "A";
            }
            if (sum == 'O' * 3) {
                return "B";
            }
        }
        sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += board[i][i];
        }
        if (sum == 'X' * 3) {
            return "A";
        }
        if (sum == 'O' * 3) {
            return "B";
        }
        sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += board[2 - i][i];
        }
        if (sum == 'X' * 3) {
            return "A";
        }
        if (sum == 'O' * 3) {
            return "B";
        }
        if (n < 9) {
            return "Pending";
        }
        return "Draw";
    }
}