class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        
        vector<string> res;
        unordered_map<char, vector<pair<int, int>>> m;
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[i].size(); ++j) {
                m[board[i][j]].push_back({i, j});
            }
        }
        for (auto& word : words) {
            if (m.count(word[0]) > 0) {
                for (auto& p : m[word[0]]) {
                    if (dfs(board, word, p.first, p.second, 0)) {
                        res.push_back(word);
                        break;
                    }
                }
            }
        }
        return res;
    }
};