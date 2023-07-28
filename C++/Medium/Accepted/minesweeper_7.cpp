class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        int m = board.size(), n = board[0].size();
        int cnt = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int xx = x + i, yy = y + j;
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && (board[xx][yy] == 'M' || board[xx][yy] == 'X')) cnt++;
            }
        }
        if (cnt > 0) {
            board[x][y] = cnt + '0';
            return board;
        }
        board[x][y] = 'B';
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int xx = x + i, yy = y + j;
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && board[xx][yy] == 'E') {
                    vector<int> v = {xx, yy};
                    updateBoard(board, v);
                }
            }
        }
        return board;
    }
};