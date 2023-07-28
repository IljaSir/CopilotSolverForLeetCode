class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int m = board.size(), n = board[0].size();
        vector<vector<int>> tmp(m, vector<int>(n));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cnt = 0;
                for (int x = max(0, i - 1); x <= min(m - 1, i + 1); ++x) {
                    for (int y = max(0, j - 1); y <= min(n - 1, j + 1); ++y) {
                        if (x == i && y == j) continue;
                        cnt += board[x][y] & 1;
                    }
                }
                if (board[i][j] == 1 && (cnt == 2 || cnt == 3)) tmp[i][j] = 1;
                if (board[i][j] == 0 && cnt == 3) tmp[i][j] = 1;
            }
        }
        board = tmp;
    }
};