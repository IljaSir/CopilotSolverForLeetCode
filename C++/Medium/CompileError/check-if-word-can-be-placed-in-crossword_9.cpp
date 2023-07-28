class Solution {
public:
    bool placeWordInCrossword(vector<vector<char>>& board, string word) {
        
        int m = board.size(), n = board[0].size();
        int i, j, k, l, len;
        // check horizontal
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (board[i][j] != ' ' && board[i][j] != word[0]) {
                    continue;
                }
                len = 0;
                for (k = j; k < n; k++) {
                    if (board[i][k] == '#') {
                        break;
                    }
                    len++;
                }
                if (len < word.size()) {
                    continue;
                }
                for (l = 0; l < word.size(); l++) {
                    if (board[i][j + l] != ' ' && board[i][j + l] != word[l]) {
                        break;
                    }
                }
                if (l == word.size()) {
                    if (j > 0 && board[i][j - 1] != '#') {
                        continue;
                    }
                    if (j + word.size() < n && board[i][j + word.size()] != '#') {
                        continue;
                    }
                    return true;
                }
            }
        }
        // check vertical
        for (j = 0; j < n; j++) {
            for (i = 0; i < m; i++) {
                if (board[i][j] != ' ' && board[i][j] != word[0]) {
                    continue;
                }
                len = 0;
                for (k = i; k < m; k++) {
                    if (board[k][j] == '#') {
                        break;
                    }
                    len++;
                }
                if (len < word.size()) {
                    continue;
                }
                for (l = 0; l < word.size(); l++) {
                    if (board[i + l][j] != ' ' && board[i + l][j] != word[l]) {
                        break;
                    }
                }
                if (l == word.size()) {
                    if (i > 0 && board[i - 1][j] != '#') {
                        continue;
                    }
                    if (i + word.size() < m && board[i + word.size()][j] != '#') {
                        continue;
                    }
                    return
    }
};