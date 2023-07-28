class Solution {
    public void gameOfLife(int[][] board) {
        
        int[][] boardCopy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boardCopy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveNeighbors = 0;
                if (i > 0 && j > 0 && boardCopy[i - 1][j - 1] == 1) {
                    liveNeighbors++;
                }
                if (i > 0 && boardCopy[i - 1][j] == 1) {
                    liveNeighbors++;
                }
                if (i > 0 && j < board[0].length - 1 && boardCopy[i - 1][j + 1] == 1) {
                    liveNeighbors++;
                }
                if (j > 0 && boardCopy[i][j - 1] == 1) {
                    liveNeighbors++;
                }
                if (j < board[0].length - 1 && boardCopy[i][j + 1] == 1) {
                    liveNeighbors++;
                }
                if (i < board.length - 1 && j > 0 && boardCopy[i + 1][j - 1] == 1) {
                    liveNeighbors++;
                }
                if (i < board.length - 1 && boardCopy[i + 1][j] == 1) {
                    liveNeighbors++;
                }
                if (i < board.length - 1 && j < board[0].length - 1 && boardCopy[i + 1][j + 1] == 1) {
                    liveNeighbors++;
                }
                if (boardCopy[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 0;
                }
                if (boardCopy[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}