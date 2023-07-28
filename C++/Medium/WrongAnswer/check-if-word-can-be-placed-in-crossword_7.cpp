class Solution {
public:
    bool placeWordInCrossword(vector<vector<char>>& board, string word) {
        
        int m = board.size();
        int n = board[0].size();
        int len = word.length();
        vector<vector<int>> row(m, vector<int>(n, 0));
        vector<vector<int>> col(n, vector<int>(m, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '#') {
                    row[i][j] = 0;
                } else {
                    row[i][j] = (j == 0 ? 0 : row[i][j-1]) + 1;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (board[j][i] == '#') {
                    col[i][j] = 0;
                } else {
                    col[i][j] = (j == 0 ? 0 : col[i][j-1]) + 1;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (row[i][j] >= len) {
                    bool flag = true;
                    for (int k = 0; k < len; ++k) {
                        if (board[i][j-k] != ' ' && board[i][j-k] != word[k]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return true;
                    }
                }
                if (col[j][i] >= len) {
                    bool flag = true;
                    for (int k = 0; k < len; ++k) {
                        if (board[i-k][j] != ' ' && board[i-k][j] != word[k]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
};