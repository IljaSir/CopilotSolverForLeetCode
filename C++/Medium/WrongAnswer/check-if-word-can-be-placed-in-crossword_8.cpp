class Solution {
public:
    bool placeWordInCrossword(vector<vector<char>>& board, string word) {
        
        int n = board.size();
        int m = board[0].size();
        int len = word.size();
        if (len > m && len > n) return false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == ' ' || board[i][j] == word[0]) {
                    if (check(board, word, i, j, 1, 0) || check(board, word, i, j, 0, 1)) return true;
                }
            }
        }
        return false;
    }
    bool check(vector<vector<char>>& board, string word, int x, int y, int dx, int dy) {
        int len = word.size();
        int n = board.size();
        int m = board[0].size();
        for (int i = 0; i < len; i++) {
            if (x < 0 || x >= n || y < 0 || y >= m || (board[x][y] != ' ' && board[x][y] != word[i])) return false;
            x += dx;
            y += dy;
        }
        return true;
    }
};