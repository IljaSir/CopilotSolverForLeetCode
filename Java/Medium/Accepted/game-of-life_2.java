class Solution {
    public void gameOfLife(int[][] board) {
        
        int[][] temp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                temp[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                if (i - 1 >= 0) {
                    count += temp[i - 1][j];
                    if (j - 1 >= 0) {
                        count += temp[i - 1][j - 1];
                    }
                    if (j + 1 < board[0].length) {
                        count += temp[i - 1][j + 1];
                    }
                }
                if (i + 1 < board.length) {
                    count += temp[i + 1][j];
                    if (j - 1 >= 0) {
                        count += temp[i + 1][j - 1];
                    }
                    if (j + 1 < board[0].length) {
                        count += temp[i + 1][j + 1];
                    }
                }
                if (j - 1 >= 0) {
                    count += temp[i][j - 1];
                }
                if (j + 1 < board[0].length) {
                    count += temp[i][j + 1];
                }
                if (temp[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}