class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {
        
        int dx[8] = { 1, 1, 1, 0, 0, -1, -1, -1 };
        int dy[8] = { 1, 0, -1, 1, -1, 1, 0, -1 };
        for (int i = 0; i < 8; i++) {
            int x = rMove + dx[i];
            int y = cMove + dy[i];
            int count = 0;
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == '.') break;
                if (board[x][y] == color) {
                    if (count >= 1) return true;
                    break;
                }
                count++;
                x += dx[i];
                y += dy[i];
            }
        }
        return false;
    }
};