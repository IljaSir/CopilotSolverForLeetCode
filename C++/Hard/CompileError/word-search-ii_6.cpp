class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        
        vector<string> result;
        if (board.size() == 0 || board[0].size() == 0) {
            return result;
        }
        Trie trie;
        for (auto word : words) {
            trie.insert(word);
        }
        int m = board.size();
        int n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, "", trie, visited, result);
            }
        }
        return result;
    }
};