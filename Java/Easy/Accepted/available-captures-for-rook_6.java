class Solution {
    public int numRookCaptures(char[][] board) {
        
        int x = 0;
        int y = 0;
        int count = 0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(board[i][j] == 'R'){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        for(int i=x;i>=0;i--){
            if(board[i][y] == 'B'){
                break;
            }
            if(board[i][y] == 'p'){
                count++;
                break;
            }
        }
        for(int i=x;i<8;i++){
            if(board[i][y] == 'B'){
                break;
            }
            if(board[i][y] == 'p'){
                count++;
                break;
            }
        }
        for(int i=y;i>=0;i--){
            if(board[x][i] == 'B'){
                break;
            }
            if(board[x][i] == 'p'){
                count++;
                break;
            }
        }
        for(int i=y;i<8;i++){
            if(board[x][i] == 'B'){
                break;
            }
            if(board[x][i] == 'p'){
                count++;
                break;
            }
        }
        return count;
    }
}