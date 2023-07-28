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
    public boolean win(String[] B, char P) {
        // B: board, P: player
        // Check all rows
        for (int i = 0; i < 3; ++i) {
            int count = 0;
            for (int j = 0; j < 3; ++j) {
                if (B[i].charAt(j) == P) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        // Check all columns
        for (int j = 0; j < 3; ++j) {
            int count = 0;
            for (int i = 0; i < 3; ++i) {
                if (B[i].charAt(j) == P) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        // Check diagonals
        if (B[0].charAt(0) == P && B[1].charAt(1) == P && B[2].charAt(2) == P) {
            return true;
        }
        if (B[0].charAt(2) == P && B[1].charAt(1) == P && B[2].charAt(0) == P) {
            return true;
        }
        return false;
    }
}