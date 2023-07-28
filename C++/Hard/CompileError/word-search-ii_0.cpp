class Solution {
public:
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        
        vector<string> res;
        for (auto& word : words) {
            if (exist(board, word)) {
                res.push_back(word);
            }
        }
        return res;
    }
    bool exist(vector<vector<char>>& board, string word) {
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].size(); j++) {
                if (board[i][j] == word[0]) {
                    if (find(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
};