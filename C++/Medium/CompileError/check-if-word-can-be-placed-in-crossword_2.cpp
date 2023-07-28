class Solution {
public:
    bool placeWordInCrossword(vector<vector<char>>& board, string word) {
        
        int m = board.size(), n = board[0].size();
        int len = word.size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ' ' || board[i][j] == word[0]) {
                    if (j + len <= n && (j == 0 || board[i][j - 1] == '#')) {
                        int k = 0;
                        for (; k < len; k++) {
                            if (board[i][j + k] != ' ' && board[i][j + k] != word[k])
                                break;
                        }
                        if (k == len && (j + len == n || board[i][j + len] == '#'))
                            return true;
                    }
                    if (j - len >= -1 && (j == n - 1 || board[i][j + 1] == '#')) {
                        int k = 0;
                        for (; k < len; k++) {
                            if (board[i][j - k] != ' ' && board[i][j - k] != word[k])
                                break;
                        }
                        if (k == len && (j - len == -1 || board[i][j - len] == '#'))
                            return true;
                    }
                    if (i + len <= m && (i == 0 || board[i - 1][j] == '#')) {
                        int k = 0;
                        for (; k < len; k++) {
                            if (board[i + k][j] != ' ' && board[i + k][j] != word[k])
                                break;
                        }
                        if (k == len && (i + len == m || board[i + len][j] == '#'))
                            return true;
                    }
                    if (i - len >= -1 && (i == m - 1 || board[i + 1][j] == '#')) {
                        int k = 0;
                        for (; k < len; k++) {
                            if (board[i - k][j] != ' ' && board[i - k][j] != word[k])
                                break;
                        }
                        if (k == len && (i - len == -1 || board[i - len][j] == '#'))
                            return true;
    }
};