class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        
        int n = board.size();
        int m = board[0].size();
        int i = click[0];
        int j = click[1];
        if(board[i][j] == 'M'){
            board[i][j] = 'X';
            return board;
        }
        if(board[i][j] == 'E'){
            int cnt = 0;
            for(int x = max(0, i-1); x <= min(n-1, i+1); x++){
                for(int y = max(0, j-1); y <= min(m-1, j+1); y++){
                    if(x == i && y == j) continue;
                    if(board[x][y] == 'M' || board[x][y] == 'X'){
                        cnt++;
                    }
                }
            }
            if(cnt == 0){
                board[i][j] = 'B';
                for(int x = max(0, i-1); x <= min(n-1, i+1); x++){
                    for(int y = max(0, j-1); y <= min(m-1, j+1); y++){
                        if(x == i && y == j) continue;
                        if(board[x][y] == 'E'){
                            vector<int> click = {x, y};
                            updateBoard(board, click);
                        }
                    }
                }
            }
            else{
                board[i][j] = '0' + cnt;
            }
        }
        return board;
    }
};