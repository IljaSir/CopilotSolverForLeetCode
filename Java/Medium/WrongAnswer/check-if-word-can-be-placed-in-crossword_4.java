class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == ' ' || board[i][j] == word.charAt(0)){
                    if(check(board, word, i, j, 0, 1)){
                        return true;
                    }
                    if(check(board, word, i, j, 1, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean check(char[][] board, String word, int i, int j, int x, int y){
        int m = board.length;
        int n = board[0].length;
        int k = 0;
        int ti = i, tj = j;
        while(k < word.length() && ti >= 0 && ti < m && tj >= 0 && tj < n && (board[ti][tj] == ' ' || board[ti][tj] == word.charAt(k))){
            k++;
            ti += x;
            tj += y;
        }
        if(k == word.length()){
            if(ti >= 0 && ti < m && tj >= 0 && tj < n && board[ti][tj] != '#'){
                return false;
            }
            if(i - x >= 0 && i - x < m && j - y >= 0 && j - y < n && board[i - x][j - y] != '#'){
                return false;
            }
            return true;
        }
        return false;
    }
}