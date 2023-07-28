class Solution {
public:
    bool checkMove(vector<vector<char>>& board, int rMove, int cMove, char color) {
        
        int i, j, k, n = board.size(), m = board[0].size();
        int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
        int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
        for(i = 0; i < 8; i++){
            int x = rMove + dx[i];
            int y = cMove + dy[i];
            int cnt = 0;
            while(x >= 0 && x < n && y >= 0 && y < m && board[x][y] != '.'){
                if(board[x][y] == color) cnt++;
                else cnt = 0;
                if(cnt == 2){
                    return true;
                }
                x += dx[i];
                y += dy[i];
            }
        }
        return false;
    }
};