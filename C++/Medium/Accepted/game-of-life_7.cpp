class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int n = board.size(), m = board[0].size();
        vector<vector<int>> next = board;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int live = 0;
                for (int x = -1; x <= 1; ++x) {
                    for (int y = -1; y <= 1; ++y) {
                        if (x == 0 && y == 0) continue;
                        if (i + x < 0 || i + x >= n || j + y < 0 || j + y >= m) continue;
                        live += board[i + x][j + y];
                    }
                }
                if (board[i][j] == 1 && (live < 2 || live > 3)) next[i][j] = 0;
                else if (board[i][j] == 0 && live == 3) next[i][j] = 1;
            }
        }
        board = next;
    }
};