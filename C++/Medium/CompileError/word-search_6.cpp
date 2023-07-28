class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        int m = board.size();
        int n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word[0]) {
                    visited[i][j] = true;
                    if (dfs(board, word, visited, i, j, 1)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    bool dfs(vector<vector<char>>& board, string word, vector<vector<bool>>& visited, int i, int j, int k) {
        if (k == word.size()) {
            return true;
        }
        int m = board.size();
        int n = board[0].size();
        if (i > 0 && !visited[i - 1][j] && board[i - 1][j] == word[k]) {
            visited[i - 1][j] = true;
            if (dfs(board, word, visited, i - 1, j, k + 1)) {
                return true;
            }
            visited[i - 1][j] = false;
        }
        if (i < m - 1 && !visited[i + 1][j] && board[i + 1][j] == word[k]) {
            visited[i + 1][j] = true;
            if (dfs(board, word, visited, i + 1, j, k + 1)) {
                return true;
            }
            visited[i + 1][j] = false;
        }
        if (j > 0 && !visited[i][j - 1] && board[i][j - 1] == word[k]) {
            visited[i][j - 1] = true;
            if (dfs(board, word, visited, i, j - 1, k + 1)) {
                return true;
            }
            visited[i][j - 1] = false;
        }
        if (j < n - 1 && !visited[i][j + 1] && board[i][j + 1] == word[k]) {
            visited[i][j + 1] = true;
    }
};