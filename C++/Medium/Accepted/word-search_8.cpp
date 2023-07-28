class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        if (board.size() == 0) {
            return false;
        }
        if (word.size() == 0) {
            return true;
        }
        int m = board.size();
        int n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word[0] && search(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    bool search(vector<vector<char>>& board, vector<vector<bool>>& visited, string& word, int index, int i, int j) {
        if (index == word.size()) {
            return true;
        }
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || visited[i][j] || board[i][j] != word[index]) {
            return false;
        }
        visited[i][j] = true;
        if (search(board, visited, word, index + 1, i + 1, j) ||
            search(board, visited, word, index + 1, i - 1, j) ||
            search(board, visited, word, index + 1, i, j + 1) ||
            search(board, visited, word, index + 1, i, j - 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
};