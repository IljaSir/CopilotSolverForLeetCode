class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    // horizontal
                    if (j == 0 || board[i][j - 1] == '#') {
                        if (j + len < n && board[i][j + len] == '#') {
                            if (checkWord(board, i, j, word, 0, 1)) {
                                return true;
                            }
                        }
                    }
                    // vertical
                    if (i == 0 || board[i - 1][j] == '#') {
                        if (i + len < m && board[i + len][j] == '#') {
                            if (checkWord(board, i, j, word, 1, 0)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private boolean checkWord(char[][] board, int i, int j, String word, int row, int col) {
        for (int k = 0; k < word.length(); k++) {
            if (board[i][j] != ' ' && board[i][j] != word.charAt(k)) {
                return false;
            }
            i += row;
            j += col;
        }
        return true;
    }
}