class Solution {
public:
    bool placeWordInCrossword(vector<vector<char>>& board, string word) {
        
        int n = board.size();
        int m = board[0].size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == ' ' || board[i][j] == word[0]) {
                    if (check(board, i, j, word, 0, 1)) return true;
                    if (check(board, i, j, word, 1, 0)) return true;
                }
            }
        }
        return false;
    }
    
    bool check(vector<vector<char>>& board, int i, int j, string& word, int x, int y) {
        int n = board.size();
        int m = board[0].size();
        int k = 0;
        while (k < word.size() && i >= 0 && i < n && j >= 0 && j < m && (board[i][j] == ' ' || board[i][j] == word[k])) {
            i += x;
            j += y;
            k++;
        }
        if (k == word.size() && (i < 0 || i >= n || j < 0 || j >= m || board[i][j] == '#')) return true;
        return false;
    }
};