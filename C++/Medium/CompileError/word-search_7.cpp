class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[i].size(); ++j) {
                if (word[0] == board[i][j]) {
                    if (dfs(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
};