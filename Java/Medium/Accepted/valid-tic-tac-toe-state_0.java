class Solution {
    public boolean validTicTacToe(String[] board) {
        
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    xCount++;
                }
                if (board[i].charAt(j) == 'O') {
                    oCount++;
                }
            }
        }
        if (oCount > xCount || xCount - oCount > 1) {
            return false;
        }
        boolean xWin = win(board, 'X');
        boolean oWin = win(board, 'O');
        if (xWin && oWin) {
            return false;
        }
        if (oWin && oCount != xCount) {
            return false;
        }
        if (xWin && oCount == xCount) {
            return false;
        }
        return true;
    }

    public boolean win(String[] board, char ch) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == ch && board[i].charAt(1) == ch && board[i].charAt(2) == ch) {
                return true;
            }
            if (board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch) {
                return true;
            }
        }
        if (board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch) {
            return true;
        }
        if (board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch) {
            return true;
        }
        return false;
    }
}