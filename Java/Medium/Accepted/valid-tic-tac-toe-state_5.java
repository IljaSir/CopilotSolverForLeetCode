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
        if (xCount != oCount && xCount != oCount + 1) {
            return false;
        }
        if (win(board, 'X') && xCount != oCount + 1) {
            return false;
        }
        if (win(board, 'O') && xCount != oCount) {
            return false;
        }
        return true;
    }
    
    private boolean win(String[] B, char P) {
        // Check rows, columns, and diagonals.
        for (int i = 0; i < 3; ++i) {
            if (P == B[0].charAt(i) && P == B[1].charAt(i) && P == B[2].charAt(i))
                return true;
            if (P == B[i].charAt(0) && P == B[i].charAt(1) && P == B[i].charAt(2))
                return true;
        }
        if (P == B[0].charAt(0) && P == B[1].charAt(1) && P == B[2].charAt(2))
            return true;
        if (P == B[0].charAt(2) && P == B[1].charAt(1) && P == B[2].charAt(0))
            return true;
        return false;
    }
}