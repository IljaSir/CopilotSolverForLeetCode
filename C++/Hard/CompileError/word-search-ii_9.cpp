class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        
        vector<string> result;
        if (words.empty()) return result;
        Trie trie;
        for (auto& word : words) trie.insert(word);
        int m = board.size(), n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(board, i, j, visited, trie, "", result);
            }
        }
        return result;
    }

    void dfs(vector<vector<char>>& board, int i, int j, vector<vector<bool>>& visited, Trie& trie, string word, vector<string>& result) {
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || visited[i][j]) return;
        word += board[i][j];
        if (!trie.startsWith(word)) return;
        if (trie.search(word)) result.push_back(word);
        visited[i][j] = true;
        dfs(board, i - 1, j, visited, trie, word, result);
        dfs(board, i + 1, j, visited, trie, word, result);
        dfs(board, i, j - 1, visited, trie, word, result);
        dfs(board, i, j + 1, visited, trie, word, result);
        visited[i][j] = false;
    }
};