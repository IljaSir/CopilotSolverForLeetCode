class Solution {
    public void gameOfLife(int[][] board) {
        
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int n = getNeighbors(board, i, j);
                if (board[i][j] == 1) {
                    if (n < 2) {
                        newBoard[i][j] = 0;
                    } else if (n == 2 || n == 3) {
                        newBoard[i][j] = 1;
                    } else if (n > 3) {
                        newBoard[i][j] = 0;
                    }
                } else {
                    if (n == 3) {
                        newBoard[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }
    public int getNeighbors(int[][] board, int i, int j) {
        int n = 0;
        if (i > 0) {
            if (board[i-1][j] == 1) {
                n++;
            }
            if (j > 0 && board[i-1][j-1] == 1) {
                n++;
            }
            if (j < board[0].length - 1 && board[i-1][j+1] == 1) {
                n++;
            }
        }
        if (i < board.length - 1) {
            if (board[i+1][j] == 1) {
                n++;
            }
            if (j > 0 && board[i+1][j-1] == 1) {
                n++;
            }
            if (j < board[0].length - 1 && board[i+1][j+1] == 1) {
                n++;
            }
        }
        if (j > 0 && board[i][j-1] == 1) {
            n++;
        }
        if (j < board[0].length - 1 && board[i][j+1] == 1) {
    }
}