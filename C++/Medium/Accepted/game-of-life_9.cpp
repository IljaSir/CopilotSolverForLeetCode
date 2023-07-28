class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int m = board.size();
        int n = board[0].size();
        int count = 0;
        int dir[8][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                count = 0;
                for(int k = 0; k < 8; k++) {
                    int x = i + dir[k][0];
                    int y = j + dir[k][1];
                    if(x >= 0 && x < m && y >= 0 && y < n) {
                        if(board[x][y] == 1 || board[x][y] == 2) {
                            count++;
                        }
                    }
                }
                if(board[i][j] == 1 && (count < 2 || count > 3)) {
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && count == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }
};