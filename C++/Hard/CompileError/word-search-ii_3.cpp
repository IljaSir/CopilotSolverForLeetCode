class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        
        int m = board.size();
        int n = board[0].size();
        vector<string> res;
        for (auto& word : words) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word[0]) {
                        if (dfs(board, word, i, j, 0)) {
                            res.push_back(word);
                        }
                    }
                }
            }
        }
        return res;
    }
};