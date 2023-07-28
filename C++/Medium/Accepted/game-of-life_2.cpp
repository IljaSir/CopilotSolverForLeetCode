class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int m = board.size(), n = board[0].size();
        vector<vector<int>> temp(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (i > 0) {
                    count += board[i - 1][j] & 1;
                    if (j > 0) count += board[i - 1][j - 1] & 1;
                    if (j < n - 1) count += board[i - 1][j + 1] & 1;
                }
                if (i < m - 1) {
                    count += board[i + 1][j] & 1;
                    if (j > 0) count += board[i + 1][j - 1] & 1;
                    if (j < n - 1) count += board[i + 1][j + 1] & 1;
                }
                if (j > 0) count += board[i][j - 1] & 1;
                if (j < n - 1) count += board[i][j + 1] & 1;
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) temp[i][j] = 1;
                } else {
                    if (count == 3) temp[i][j] = 1;
                }
            }
        }
        board = temp;
    }
};