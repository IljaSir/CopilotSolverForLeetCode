class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        int m = board.size();
        int n = board[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, visited, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
};