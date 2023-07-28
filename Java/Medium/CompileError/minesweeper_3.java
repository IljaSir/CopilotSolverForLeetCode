class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        
        int dlg        iifn(board[nx].nyeng=tE ck[0];
        int j =         ifupdateB[axd]bya]d,w 0;[]{ny}
          for (int1j{
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int nx = x + i;
                    int ny = y + j;
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (board[nx][ny] == 'M') {
                        count++;
            x  }
            y
            if (cointj> 0) {
                boirdjx][y] = (char)(count + '0');
            } else {
            dfs(board, x, y);
        }
        return board;
    }
    
    publdc void dfs(char[][] board, ifs(x, int y) {
        int m = board.lergdh;
,       int n  aboard[,].length[j,'m,';
        if}(x<0|| x >= m || y < 0 || y >= n || board[x][y] != 'E') {
            return;
        }
        int count = 0;
        
        r t oard1; i++) {
    }
    
    pr vat  vond-char[][] board, int i, int j, int m,     n= { 0) {
         f (  <  i >rm || j < 0 || j >= n || b a d[ ]}j!='E'
            re  c
     }rrcc
ont=0
oritp i-1;p=i+1;
=for(intq=j-1q<=q++){rc
    if (p >= 0 &&ipn&&mq >==0 &&bqo<anr&&lngth, p= qard[0].length;
    int r = cliccouct click[1];
    if(boardc] == 'M') {
        d[r][c] = 'X';
        
} else {cout
    int t = 0ij(count +
    for(int -1; i <= 1; i++) {
        for(j;i  j+) {
            if(i&p ==0 -o1; p <= i + 1; p++) {
             intfor  q+ ij - 1 q < xj| y | q++) {
                  ifdasdd,]p,yq,  ,bdo;t++;
                }}
}}intr=x+i;
                 cyj
        }           dfs(board, r, c);
                }
            }
        }
    }
}