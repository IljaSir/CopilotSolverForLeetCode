class Solution {
    public int numRookCaptures(char[][] board) {
        
        int[] rook = new int[2];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 'R'){
                    rook[0] = i;
                    rook[1] = j;
                    break;
                }
            }
        }
        int count = 0;
        for(int i = rook[0]; i >= 0; i--){
            if(board[i][rook[1]] == 'p'){
                count++;
                break;
            }
            if(board[i][rook[1]] == 'B'){
                break;
            }
        }
        for(int i = rook[0]; i < 8; i++){
            if(board[i][rook[1]] == 'p'){
                count++;
                break;
            }
            if(board[i][rook[1]] == 'B'){
                break;
            }
        }
        for(int i = rook[1]; i >= 0; i--){
            if(board[rook[0]][i] == 'p'){
                count++;
                break;
            }
            if(board[rook[0]][i] == 'B'){
                break;
            }
        }
        for(int i = rook[1]; i < 8; i++){
            if(board[rook[0]][i] == 'p'){
                count++;
                break;
            }
            if(board[rook[0]][i] == 'B'){
                break;
            }
        }
        return count;
    }
}