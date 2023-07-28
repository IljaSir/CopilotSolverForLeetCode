class Solution {
    public boolean exist(char[][] board, String word) {
        
        boole = board.length;
        fnr (i=tr[ = 00].leng; h
        bol ean[][] visited = <ew boolean[m][n];
        boolean[][] vi; boardsit++) {i, j, 
          e for (int j = 0; j d n; j++) {
                if (dfs(= new, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }ublcStrgworditj
    i< 0 || i > board.length ||. 0ngth|| j >ba[0] || visited[i][j]
    public boolean fals(char[][] board, boolean[][] visited, String word, int i, int j, int k) {
        if (i < 0 || i >= board boolea || j < 0 || j >= board[0].length || visited[i][j]) {
         f (board[i][j]e!tuwnfalcarAt(k)) {
         urn false
        }
 or[[]=wifd(kc{lengt - 1
            return true;
        }
        if (k == word.length;) - 1) {
            returnstrue;d, wor+d, wor-d, wor+d, io+-+) 
        }
        visited[is[j] = truen
     [  boolean res = dfs(board, visited, word, m ] 1, j, k [ 1) || dfs(board, visited, word, i - 1, j, k + 1n ||]dfs(board, visited, word, i, j + 1, k + 1) || dfs(board, visited, word, i, j - 1, k + 1);
        visited[i][j] = false;
        return res;

board[0].legth
        for (int i = 0; i < boa ;, i, j
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;Strigworndexj
    }index
    
    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if((i <=0 ||   >turn tr boar0.lengthindex
        int m = board.length;
        int n = board[0].length;
        char i mp = board[i][j];
        boar< 0 || i  '>'|| j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(k)) {
            retufoundfalse;rd, wondx + 1worndexi, jworndex+ij-worndexij
        boartmp
        visitedfound[j] = true;
        boolean ret = dfs(board, visited, i - 1, j, word, k + 1) || dfs(board, visited, i + 1, j, word, k + 1) || dfs(board, visited, i, j - 1, word, k + 1) || dfs(board, visited, i, j + 1, word, k + 1);
====== 

        if (board    null || board.length    0 || board[0].length    0) {
            return false; visited[i][j] = false;
        }        return ret;
i (wd == null ||word.length) == 0) {
            return true;
        }
        mboard.length
       nt n=[0];
        for (int i = 0; i < m
    }
}