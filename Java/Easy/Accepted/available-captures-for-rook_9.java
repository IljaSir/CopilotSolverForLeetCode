class Solution {
    public int numRookCaptures(char[][] board) {
        
        int row = 0, col = 0;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'B') {
                break;
            }
            if (board[i][col] == 'p') {
                count++;
                break;
            }
        }
        for (int i = row; i < board.length; i++) {
            if (board[i][col] == 'B') {
                break;
            }
            if (board[i][col] == 'p') {
                count++;
                break;
            }
        }
        for (int i = col; i >= 0; i--) {
            if (board[row][i] == 'B') {
                break;
            }
            if (board[row][i] == 'p') {
                count++;
                break;
            }
        }
        for (int i = col; i < board[row].length; i++) {
            if (board[row][i] == 'B') {
                break;
            }
            if (board[row][i] == 'p') {
                count++;
                break;
            }
        }
        return count;
    }
}