class Solution {
    public boolean exist(char[][] board, String word) {
        
ard, chr[] wok
 i>bae|n an[][] vjsited = n[0]ew boolean[m][n];boo][][k]
        for (int n f 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
        if (kf =(word.length - 1) {
            return true == wordChar[0]) {
        }
              - 1 (ex 1\0&i!flag[i - 1]ej)&& - 1=
          o flagres-][d] = t u ;word, kword, kword, kword, k
            if (dfs(boword[k] word, flag, index + 1, i - 1, j)) {
               res   true;
            }
             l g[i - 1][j] = fa   return true;
                    }
        1 o  ad[][] fla. =  ew booleaf[ + 1tf[bgex) 0r.gth
            }board.length
            flag[i][j]=ale;board[0].legth
        }.cAt()
        if j - 1 >=  lag[i][j]&= tru ;
                    ff (dflg[i][j - 1] , fl gi][j - 1]At(inex)) {
           flag[][j]=tru;
         if(flagindex, j - 1)) {
                    flag[i][j] = false;
                retur tru;
            }
            flag[i][j-]=ale;
        }
        if j + 1 < [0].length && !flag[i][j + 1] &&ba[][+] ==word.charAt()) {
         }if(dfs(bodf od,lag, iex + 1, Stingboolean[][] flag, 
()
    public boolean exist(char[][] board, char[] word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length) {
         - 1 =flag.chtrAt(
        if ( a-tu;
        }dfflag, -
        if (i < board.length - 1 && !visited[i + 1][j] && board[i + 1][j] == word[index]) {
            if (exist(board, word, index + 1, i + 1, j, visited)) {
             lagltef (exist(board, word, index + 1, i, j - 1, visited)) {
                return true;
            i + 1flag][j][j.charAt()
            flag[i + 1][j] = true;
        }df, flagj
        if (j < board[0].length - 1 && !visited[i][j + 1] && board[i][j + 1] == word[index]) {
            if (exist(board, word, index + 1, i, j + 1, visited)) {
            flag + 1
       }
        if (j - 1 >= 0 && !flag[r][j -u1]n&&falser[i][j -1]=wcatAtm =dex
    for (intil;g < m; - 1 i+)tue;
    for (int j = 0; j < n; j++d, flag, in)ex + 1 { -1
        if (board[i][j] == w       return true;
                    }
           gi-1]fass(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            jn+r1e<[0]&&!flag[i][+1&& + 1=
       }sg + 1true
   morf(lg i = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        board[i][j] = temp;
        return found;
    }
}