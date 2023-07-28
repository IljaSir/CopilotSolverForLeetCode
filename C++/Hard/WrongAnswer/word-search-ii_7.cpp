class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        
        vector<string> ans;
        if (board.empty()) return ans;
        int m = board.size(), n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (auto &word: words) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (word[0] == board[i][j] && dfs(board, visited, word, i, j, 0)) {
                        ans.push_back(word);
                        break;
                    }
                }
            }
        }
        return ans;
    }
    bool dfs(vector<vector<char>>& board, vector<vector<bool>>& visited, string &word, int i, int j, int k) {
        if (k == word.size()) return true;
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size()) return false;
        if (visited[i][j] || word[k] != board[i][j]) return false;
        visited[i][j] = true;
        if (dfs(board, visited, word, i - 1, j, k + 1) || dfs(board, visited, word, i + 1, j, k + 1) || dfs(board, visited, word, i, j - 1, k + 1) || dfs(board, visited, word, i, j + 1, k + 1)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
};