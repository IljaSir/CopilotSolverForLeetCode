class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {
        
        int i,  board.size();
        int m = board[0].size();
        int d[8][2] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < 8; i++) {
            int x = rMove + d[i][0];
            int y = cMove + d[i][1];
            int cnt = 0;
            while (x >= 0 && x < n && y >= 0 && y < m && board[x][y] != '.') {
                if (board[x][y] != color) {
                    cnt++;
                } else {
                    break;
                }
                x += d[i][0];
                y += d[[i];
            }
        }
        return false;
    }
};