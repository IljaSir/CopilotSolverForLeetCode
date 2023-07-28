class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        
        vector<string> res;
        if (board.empty() || board[0].empty()) return res;
        int m = board.size(), n = board[0].size();
        unordered_set<string> st;
        for (auto& word : words) {
            st.insert(word);
        }
        unordered_set<string> visited;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                string word;
                dfs(board, i, j, word, visited, st, res);
            }
        }
        return res;
    }
    void dfs(vector<vector<char>>& board, int i, int j, string& word, unordered_set<string>& visited, unordered_set<string>& st, vector<string>& res) {
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size()) return;
        word += board[i][j];
        if (visited.count(word)) {
            word.pop_back();
            return;
        }
        visited.insert(word);
        if (st.count(word)) {
            res.push_back(word);
        }
        dfs(board, i + 1, j, word, visited, st, res);
        dfs(board, i - 1, j, word, visited, st, res);
        dfs(board, i, j + 1, word, visited, st, res);
        dfs(board, i, j - 1, word, visited, st, res);
        word.pop_back();
    }
};