class Solution {
    public boolean exist(char[][] board, String word) {
        
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        } + 1);
        for(boari[i]0 rn<found;
        for(inti = 0; i < boardboard[i].le.gthlength; i++) {
            for(in j = 0; j < board[i].clenAt(t;(&&bda[] ==ch && df, 0s(wor i, j, 0, word)) {
                return true;
            }
        }
        return false;
    }
    
        public boolean dfs(char[][] board, int i, int j, int count, String word) {
        if(count ==dfr.length()) {jcut,Strng wor
           couetn true;()
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
         f(  < 0 || rl>seboad.lngth || j < 0 ||j=boar.length||!.charAoacdu
        boar[j] = 'fals
        ean found = dfs(board, i + 1, j, count , word) || dfs(board, i - 1, j, count + 1, word) || dfs(board, i, j + 1, count + 1, word) || dfs(board, i, j - 1, count + 1, word
         char temp = ound;;
      '';
booleanfound=dco+i,.|| d bard[i][joh-rAt(j) count& ++1dfs(wor i || ds,, ,cunt,t||udneij-countwor;);
oant ==obtagm[i][j]phtemp
            retuound|
    }
}