class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        int l = word.length();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    if (j + l <= n && board[i][j + l] == ' ') {
                        int k = 0;
                        for (k = 0; k < l; k++) {
                            if (board[i][j + k] != ' ' && board[i][j + k] != word.charAt(k)) {
                                break;
                            }
                        }
                        if (k == l) {
                            return true;
                        }
                    }
                    if (j - l >= -1 && board[i][j - l] == ' ') {
                        int k = 0;
                        for (k = 0; k < l; k++) {
                            if (board[i][j - k] != ' ' && board[i][j - k] != word.charAt(k)) {
                                break;
                            }
                        }
                        if (k == l) {
                            return true;
                        }
                    }
                    if (i + l <= m && board[i + l][j] == ' ') {
                        int k = 0;
                        for (k = 0; k < l; k++) {
                            if (board[i + k][j] != ' ' && board[i + k][j] != word.charAt(k)) {
                                break;
                            }
                        }
                        if (k == l) {
                            return true;
                        }
                    }
                    if (i - l >= -1 && board[i - l][j] == ' ') {
                        int k = 0;
                        for (k = 0; k < l; k++) {
                            if (board[i - k][j] != ' ' && board[i - k][j] != word.charAt(k)) {
                                break;
                            }
                        }
                        if (k == l) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}