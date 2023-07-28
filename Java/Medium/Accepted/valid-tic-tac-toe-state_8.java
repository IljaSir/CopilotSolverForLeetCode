class Solution {
    public boolean validTicTacToe(String[] board) {
        
        int[] count = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    count[0]++;
                } else if (board[i].charAt(j) == 'O') {
                    count[1]++;
                }
            }
        }
        if (count[0] < count[1] || count[0] > count[1] + 1) {
            return false;
        }
        if (win(board, 'X') && count[0] != count[1] + 1) {
            return false;
        }
        if (win(board, 'O') && count[0] != count[1]) {
            return false;
        }
        return true;
    }

    private boolean win(String[] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                return true;
            }
            if (board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player) {
                return true;
            }
        }
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            return true;
        }
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            return true;
        }
        return false;
    }
}