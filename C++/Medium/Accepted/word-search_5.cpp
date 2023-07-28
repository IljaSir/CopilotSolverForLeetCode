class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        int m = board.size();
        int n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word[0]) {
                    if (dfs(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    bool dfs(vector<vector<char>>& board, string& word, int index, int i, int j, vector<vector<bool>>& visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || board[i][j] != word[index] || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        bool result = dfs(board, word, index + 1, i + 1, j, visited) || dfs(board, word, index + 1, i - 1, j, visited) || dfs(board, word, index + 1, i, j + 1, visited) || dfs(board, word, index + 1, i, j - 1, visited);
        visited[i][j] = false;
        return result;
    }
};