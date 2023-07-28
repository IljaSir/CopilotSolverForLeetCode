class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {
        
        int n = board.size();
        int m = board[0].size();
        int dx[8] = {0, 1, 1, 1, 0, -1, -1, -1};
        int dy[8] = {1, 1, 0, -1, -1, -1, 0, 1};
        char opp = color == 'W' ? 'B' : 'W';
        for (int i = 0; i < 8; ++i) {
            int x = rMove + dx[i], y = cMove + dy[i];
            if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != opp) {
                continue;
            }
            int len = 0;
            while (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == opp) {
                x += dx[i];
                y += dy[i];
                ++len;
            }
            if (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == color && len >= 2) {
                return true;
            }
        }
        return false;
    }
};