class Solution {
    public boolean validTicTacToe(String[] board) {
        
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    countX++;
                } else if (board[i].charAt(j) == 'O') {
                    countO++;
                }
            }
        }
        if (countO > countX || countX - countO > 1) {
            return false;
        }
        boolean xWin = checkWin(board, 'X');
        boolean oWin = checkWin(board, 'O');
        if (xWin && oWin) {
            return false;
        }
        if (xWin && countX == countO) {
            return false;
        }
        if (oWin && countX > countO) {
            return false;
        }
        return true;
    }

    private boolean checkWin(String[] board, char c) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) {
                return true;
            }
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
                return true;
            }
        }
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
            return true;
        }
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) {
            return true;
        }
        return false;
    }
}