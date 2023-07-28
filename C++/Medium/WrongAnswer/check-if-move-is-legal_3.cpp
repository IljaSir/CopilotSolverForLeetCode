class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {
        
        int dx[8] = {0, 0, 1, -1, 1, -1, 1, -1};
        int dy[8] = {1, -1, 0, 0, 1, -1, -1, 1};
        for (int i = 0; i < 8; i++) {
            int cnt = 0;
            int x = rMove, y = cMove;
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == color) {
                    if (cnt >= 2) {
                        return true;
                    }
                    break;
                } else if (board[x][y] == '.') {
                    break;
                }
                cnt++;
                x += dx[i];
                y += dy[i];
            }
        }
        return false;
    }
};