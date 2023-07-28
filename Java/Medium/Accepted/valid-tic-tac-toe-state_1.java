class Solution {
    public boolean validTicTacToe(String[] board) {
        
        int xCount = 0, oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') xCount++;
                else if (board[i].charAt(j) == 'O') oCount++;
            }
        }
        if (oCount > xCount || xCount > oCount + 1) return false;
        if (win(board, 'X') && xCount == oCount) return false;
        if (win(board, 'O') && xCount > oCount) return false;
        return true;
    }
    private boolean win(String[] B, char P) {
        for (int i = 0; i < 3; i++) {
            if (B[i].charAt(0) == P && B[i].charAt(1) == P && B[i].charAt(2) == P) return true;
            if (B[0].charAt(i) == P && B[1].charAt(i) == P && B[2].charAt(i) == P) return true;
        }
        if (B[0].charAt(0) == P && B[1].charAt(1) == P && B[2].charAt(2) == P) return true;
        if (B[0].charAt(2) == P && B[1].charAt(1) == P && B[2].charAt(0) == P) return true;
        return false;
    }
}