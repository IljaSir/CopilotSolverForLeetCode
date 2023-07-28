class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        char[] w = word.toCharArray();
        int len = w.length;
        
        //check horizontal
        for(int i=0; i<m; i++){
            for(int j=0; j<=n-len; j++){
                if(board[i][j] == ' ' || board[i][j] == w[0]){
                    if(check(board, w, i, j, 0, 1)){
                        return true;
                    }
                }
            }
        }
        
        //check vertical
        for(int j=0; j<n; j++){
            for(int i=0; i<=m-len; i++){
                if(board[i][j] == ' ' || board[i][j] == w[0]){
                    if(check(board, w, i, j, 1, 0)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean check(char[][] board, char[] w, int i, int j, int di, int dj){
        int len = w.length;
        for(int k=0; k<len; k++){
            if(board[i][j] == '#') return false;
            
            if(board[i][j] != ' ' && board[i][j] != w[k]){
                return false;
            }
            
            i += di;
            j += dj;
        }
        
        return i == board.length || j == board[0].length || board[i][j] == '#';
    }
}