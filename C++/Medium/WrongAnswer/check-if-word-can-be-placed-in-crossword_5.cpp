class Solution {
public:
    bool placeWordInCrossword(vector<vector<char>>& board, string word) {
        
        int m = board.size();
        int n = board[0].size();
        vector<vector<char>> board2(n, vector<char>(m));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board2[j][i] = board[i][j];
            }
        }
        return check(board, word) || check(board2, word);
    }
    bool check(vector<vector<char>>& board, string word) {
        int m = board.size();
        int n = board[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - word.length() + 1; j++) {
                if (board[i][j] == ' ' || board[i][j] == word[0]) {
                    int k = 0;
                    for (; k < word.length(); k++) {
                        if (board[i][j + k] == '#' || (board[i][j + k] != ' ' && board[i][j + k] != word[k])) {
                            break;
                        }
                    }
                    if (k == word.length() && (j + k == n || board[i][j + k] == '#')) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
};