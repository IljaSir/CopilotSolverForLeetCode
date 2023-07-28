class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {
        
        if (board[rMove][cMove] != '.') {
            return false;
        }
        int dr[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        int dc[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int r = rMove + dr[i];
            int c = cMove + dc[i];
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                if (board[r][c] == '.') {
                    break;
                }
                if (board[r][c] == color) {
                    if (abs(r - rMove) + abs(c - cMove) >= 3) {
                        count++;
                    }
                    break;
                }
                r += dr[i];
                c += dc[i];
            }
        }
        return count > 0;
    }
};