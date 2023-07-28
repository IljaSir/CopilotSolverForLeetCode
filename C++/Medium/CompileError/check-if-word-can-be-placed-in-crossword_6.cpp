class Solution {
public:
    bool placeWordInCrossword(vector<vector<char>>& board, string word) {
        
        int m = board.size(), n = board[0].size();
        int len = word.size();
        // check horizontal
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - len + 1; j++) {
                if (board[i][j] == ' ' || board[i][j] == word[0]) {
                    int k = 1;
                    for (k = 1; k < len; k++) {
                        if (board[i][j + k] != ' ' && board[i][j + k] != word[k]) break;
                    }
                    if (k == len && (j + len == n || board[i][j + len] == '#')) return true;
                }
                if (board[i][j + len - 1] == ' ' || board[i][j + len - 1] == word[len - 1]) {
                    int k = 1;
                    for (k = 1; k < len; k++) {
                        if (board[i][j + len - 1 - k] != ' ' && board[i][j + len - 1 - k] != word[k]) break;
                    }
                    if (k == len && (j == 0 || board[i][j - 1] == '#')) return true;
                }
            }
        }
        // check vertical
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m - len + 1; i++) {
                if (board[i][j] == ' ' || board[i][j] == word[0]) {
                    int k = 1;
                    for (k = 1; k < len; k++) {
                        if (board[i + k][j] != ' ' && board[i + k][j] != word[k]) break;
                    }
                    if (k == len && (i + len == m || board[i + len][j] == '#')) return true;
                }
                if (board[i + len - 1][j] == ' ' || board[i + len - 1][j] == word[len - 1]) {
                    int k = 1;
                    for (k = 1; k < len; k++) {
    }
};