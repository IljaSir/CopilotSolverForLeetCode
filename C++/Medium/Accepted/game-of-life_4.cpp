class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int m = board.size(), n = board[0].size();
        vector<vector<int>> ans = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                if (i - 1 >= 0) {
                    if (j - 1 >= 0) cnt += board[i - 1][j - 1];
                    cnt += board[i - 1][j];
                    if (j + 1 < n) cnt += board[i - 1][j + 1];
                }
                if (j - 1 >= 0) cnt += board[i][j - 1];
                if (j + 1 < n) cnt += board[i][j + 1];
                if (i + 1 < m) {
                    if (j - 1 >= 0) cnt += board[i + 1][j - 1];
                    cnt += board[i + 1][j];
                    if (j + 1 < n) cnt += board[i + 1][j + 1];
                }
                if (board[i][j] == 1) {
                    if (cnt < 2 || cnt > 3) ans[i][j] = 0;
                } else {
                    if (cnt == 3) ans[i][j] = 1;
                }
            }
        }
        board = ans;
    }
};