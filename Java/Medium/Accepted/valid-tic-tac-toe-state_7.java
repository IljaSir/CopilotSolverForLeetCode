class Solution {
    public boolean validTicTacToe(String[] board) {
        
        int xCount = 0;
        int oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') {
                    xCount++;
                } else if (c == 'O') {
                    oCount++;
                }
            }
        }
        if (oCount > xCount || xCount - oCount > 1) {
            return false;
        }
        if (win(board, 'X') && oCount == xCount) {
            return false;
        }
        if (win(board, 'O') && oCount != xCount) {
            return false;
        }
        return true;
    }
    private boolean win(String[] board, char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == p && board[i].charAt(1) == p && board[i].charAt(2) == p) {
                return true;
            }
            if (board[0].charAt(i) == p && board[1].charAt(i) == p && board[2].charAt(i) == p) {
                return true;
            }
        }
        if (board[0].charAt(0) == p && board[1].charAt(1) == p && board[2].charAt(2) == p) {
            return true;
        }
        if (board[0].charAt(2) == p && board[1].charAt(1) == p && board[2].charAt(0) == p) {
            return true;
        }
        return false;
    }
}