class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        
        vector<string> res;
        if (board.empty() || board[0].empty()) return res;
        int m = board.size(), n = board[0].size();
        unordered_set<string> dict(words.begin(), words.end());
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        string path;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(board, dict, visited, path, i, j, res);
            }
        }
        return res;
    }
};