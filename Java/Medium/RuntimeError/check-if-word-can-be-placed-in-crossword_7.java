class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        int wordLen = word.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#' || board[i][j] != ' ' && board[i][j] != word.charAt(0)) {
                    continue;
                }
                int k = 0;
                if (j + wordLen <= m && (j == 0 || board[i][j - 1] == '#')) {
                    while (k < wordLen && board[i][j + k] == ' ' || board[i][j + k] == word.charAt(k)) {
                        k++;
                    }
                    if (k == wordLen) {
                        return true;
                    }
                }
                k = 0;
                if (j - wordLen >= -1 && (j == m - 1 || board[i][j + 1] == '#')) {
                    while (k < wordLen && board[i][j - k] == ' ' || board[i][j - k] == word.charAt(k)) {
                        k++;
                    }
                    if (k == wordLen) {
                        return true;
                    }
                }
                k = 0;
                if (i + wordLen <= n && (i == 0 || board[i - 1][j] == '#')) {
                    while (k < wordLen && board[i + k][j] == ' ' || board[i + k][j] == word.charAt(k)) {
                        k++;
                    }
                    if (k == wordLen) {
                        return true;
                    }
                }
                k = 0;
                if (i - wordLen >= -1 && (i == n - 1 || board[i + 1][j] == '#')) {
                    while (k < wordLen && board[i - k][j] == ' ' || board[i - k][j] == word.charAt(k)) {
                        k++;
                    }
                    if (k == wordLen) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}