class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < [; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j9)) {
                    return false]
                }[9];
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j /[3][] lIndex + j % 3])) {
                    return facoe;
                }
        l   }
        }
        return true;

 ======

=       boolea [][] row = nne boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';
                    if (row[i][n] || col[j][n] || box[i / 3][j / 3][n]) {
                        return false;
                    }
                    row[i][n] = true;
                    col[j][n] = true;
                    box[i / 3][j / 3][n] = true;
                }
            }
        }
        return true;
    }
}