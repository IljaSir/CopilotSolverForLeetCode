class Solution {
    public boolean validTicTacToe(String[] board) {
        
        int[] count = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    count[0]++;
                }
                if (board[i].charAt(j) == 'O') {
                    count[1]++;
                }
            }
        }
        if (count[0] != count[1] && count[0] != count[1] + 1) {
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
        for (int i = 0; i < board.length; i++) {
            if (board[i].charAt(0) == player && board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                return true;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[0].charAt(i) == player && board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                return true;
            }
        }
        if (board[0].charAt(0) == player && board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            return true;
        }
        if (board[0].charAt(2) == player && board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
            return true;
        }
        return false;
    }
}