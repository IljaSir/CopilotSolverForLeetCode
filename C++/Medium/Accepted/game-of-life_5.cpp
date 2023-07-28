class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        
        int m = board.size();
        int n = board[0].size();
        vector<vector<int>> temp(m, vector<int>(n, 0));
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = 0;
                if(i - 1 >= 0){
                    if(board[i - 1][j] == 1){
                        count++;
                    }
                    if(j - 1 >= 0){
                        if(board[i - 1][j - 1] == 1){
                            count++;
                        }
                    }
                    if(j + 1 < n){
                        if(board[i - 1][j + 1] == 1){
                            count++;
                        }
                    }
                }
                if(i + 1 < m){
                    if(board[i + 1][j] == 1){
                        count++;
                    }
                    if(j - 1 >= 0){
                        if(board[i + 1][j - 1] == 1){
                            count++;
                        }
                    }
                    if(j + 1 < n){
                        if(board[i + 1][j + 1] == 1){
                            count++;
                        }
                    }
                }
                if(j - 1 >= 0){
                    if(board[i][j - 1] == 1){
                        count++;
                    }
                }
                if(j + 1 < n){
                    if(board[i][j + 1] == 1){
                        count++;
                    }
                }
                if(board[i][j] == 1){
                    if(count < 2){
                        temp[i][j] = 0;
                    }
                    else if(count == 2 || count == 3){
                        temp[i][j] = 1;
                    }
                    else{
                        temp[i][j] = 0;
                    }
                }
                else{
                    if(count == 3){
                        temp[i][j] = 1;
                    }
                    else{
                        temp[i][j] = 0;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = temp[i][j];
            }
        }
    }
};