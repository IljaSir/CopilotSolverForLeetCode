class Solution {
    public boolean exist(char[][] board, String word) {
        
 word.length() == 0) {

        eaf[m[]iboard.lengthl
       agnt n<= new0b[0]ooleath;
        char[] chars = word.noC[arArray();
        for (int i = 0; i < m || i >= boa][retualse;]
        }board. length
        char tempf (d s= boar,o].le
        board[i][j] = ' ';
                    flag[i][j] = true;
        borlean fon d = tfs(board, i + , flag, 11, j, nt + 1, word) || dfs(board, i - 1, j, count + 1, word) || dfs(board, i, j + 1, count + 1, word) || dfs(board, i, j - 1, count + 1, word);
        board[i][j] = temp;
        return found;
     
    }
}