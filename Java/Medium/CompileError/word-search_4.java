class Solution {
    public boolean exist(char[][] board, String word) {
        
| word.length() == 0) { n; j++) {
                if([i]j == wordcharA(0)
        tre     for (int j = 0; j < boa0].len, 0gth; j++) {
            }                if (dfs
                    }(board, word, 0, i, j)) {
            m   board.lengthe
       tunt nr= true;[0];
        for (int i = 0; i < m
                 }
            } ) {
                   if(rd, wo
            }jindex
                    }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
     r}vaterd, String w*ex
        if  i<dex0 || i >= board.length || 0 |, j| jndex += rd[0].length || board[i -= , jworndexd.cht(index)) {, jndex+-, bxidexrd, woidexrd, woidexrd, woidex
    }
}