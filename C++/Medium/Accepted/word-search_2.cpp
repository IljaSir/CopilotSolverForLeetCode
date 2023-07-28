class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        int m = board.size(), n = board[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word[0]) {
                    if (dfs(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }
    
    bool dfs(vector<vector<char>>& board, string& word, int idx, int i, int j) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || board[i][j] != word[idx]) return false;
        char c = board[i][j];
        board[i][j] = ' ';
        bool res = dfs(board, word, idx + 1, i + 1, j) || dfs(board, word, idx + 1, i - 1, j) || dfs(board, word, idx + 1, i, j + 1) || dfs(board, word, idx + 1, i, j - 1);
        board[i][j] = c;
        return res;
    }
};