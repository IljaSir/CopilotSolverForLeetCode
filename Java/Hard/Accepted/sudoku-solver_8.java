class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board);
    }
    private boolean solve(char[][] board) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(board[row][col] == '.') {
                    for(char num = '1'; num <= '9'; num++) {
                        if(isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if(solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char num) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == num) {
                return false;
            }
        }
        for(int j = 0; j < board[0].length; j++) {
            if(board[row][j] == num) {
                return false;
            }
        }
        int blockRow = row / 3;
        int blockCol = col / 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[blockRow * 3 + i][blockCol * 3 + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}