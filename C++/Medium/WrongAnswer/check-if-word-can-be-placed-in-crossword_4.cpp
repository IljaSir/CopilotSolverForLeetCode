class Solution {
public:
    bool placeWordInCrossword(vector<vector<char>>& board, string word) {
        
        int R = board.size(), C = board[0].size();
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (board[i][j] == ' ' || board[i][j] == word[0]) {
                    if (j == 0 || board[i][j - 1] == '#') {
                        int k = 0;
                        for (; k < word.size() && j + k < C; ++k) {
                            if (board[i][j + k] != ' ' && board[i][j + k] != word[k]) {
                                break;
                            }
                        }
                        if (k == word.size() && (j + k == C || board[i][j + k] == '#')) {
                            return true;
                        }
                    }
                    if (i == 0 || board[i - 1][j] == '#') {
                        int k = 0;
                        for (; k < word.size() && i + k < R; ++k) {
                            if (board[i + k][j] != ' ' && board[i + k][j] != word[k]) {
                                break;
                            }
                        }
                        if (k == word.size() && (i + k == R || board[i + k][j] == '#')) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
};