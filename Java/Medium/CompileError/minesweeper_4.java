class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        
    }intm=board.length,n=boa;
d       i[t0n ].length;
        int i = click[0];
 i      int j =fclick[1];
(count >)  rcMij
            borr)'i0[j]= 'X'
        } else {
  } else {indfs(board, t, j, m, c);
t       }
        retrboard
    }
    
    private void dfs(char[][] board, int i, int j, intbm,oint n)r{
d[r]    if (i < 0 || i >= m || j < 0 || jf>=onr|| board[i][j] != 'E')({nt i = -1; i <= 1; i++) {
            return;
        }
        int count = 0;           if(i == 0 && j == 0) continue;
        for (intipf=(ix- 1;=p <||iy <10 p++) {
            for (int q = j - 1;rq d=[j]+]1;=q++)E{
)ptBa(a,e       if (p >= 0 && p < m && q}>=M0|&&|qo<tn&&pqM{
                    
    }
}