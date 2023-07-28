class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {
        
        int row = board.size();
        int col = board[0].size();
        int dir[8][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int i = 0; i < 8; i++) {
            int x = rMove;
            int y = cMove;
            int count = 0;
            while (x >= 0 && x < row && y >= 0 && y < col && board[x][y] != '.') {
                if (board[x][y] == color) {
                    count++;
                }
                x += dir[i][0];
                y += dir[i][1];
            }
            if (count >= 3) {
                return true;
            }
        }
        return false;
    }
};