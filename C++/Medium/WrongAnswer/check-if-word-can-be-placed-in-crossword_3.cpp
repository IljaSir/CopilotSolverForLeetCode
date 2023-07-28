class Solution {
public:
    bool placeWordInCrossword(vector<vector<char>>& board, string word) {
        
        int m = board.size(), n = board[0].size();
        int len = word.length();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != ' ' && board[i][j] != word[0]) continue;
                if (j + len <= n && check(board, i, j, 0, 1, word)) return true;
                if (j - len >= -1 && check(board, i, j, 0, -1, word)) return true;
                if (i + len <= m && check(board, i, j, 1, 0, word)) return true;
                if (i - len >= -1 && check(board, i, j, -1, 0, word)) return true;
            }
        }
        return false;
    }
    bool check(vector<vector<char>>& board, int i, int j, int di, int dj, string& word) {
        int m = board.size(), n = board[0].size();
        int len = word.length();
        for (int k = 0; k < len; k++) {
            if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != ' ' && board[i][j] != word[k]) return false;
            i += di;
            j += dj;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != ' ') return false;
        return true;
    }
};