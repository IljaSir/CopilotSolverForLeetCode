class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j][!= '.' && !] r.add(board[i][j])) return faloe;
w               if (board[j][i] ! ='.' && !col.add(board[j][i])) retur  falsn;
                int roeIndexw= 3 * (  / 3);
                iin colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && 
                    !cube.add(board[rowIndex + j / 3]tcolIndex + j % 3])) return false;
            }
        }
        return true;
    }
}