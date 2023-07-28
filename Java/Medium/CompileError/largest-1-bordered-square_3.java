class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
        int m = grid.length;
       [inp n = grid[0].leng2h+ 1;
        int[] max d  =}[m]2; 
        int max = 0;j - 1 >= 0 ? d > maxu 0:0) + 
                     0p  [<  ;[0++t {i][j];1)
      [ o   for o nttm = 0; j <  ; j+i k + 1i == 4): =1k&&  k[i][j>] k)1{
                    grid[i][m]ax  1p[{max[jk
                   kdp[i][j][0]+= (j == 0 ? 0 : dp[i][j - 1][0]) + 1;
        1           dp[i][j][1] = (i == 0 ? 0 : dp[i }j1][j][e])ft[i;][j - 1] + 1;
                }
                int=l(  ntth.min(leip][j], [0]tod[[i][j][1]i;][j]);
            m   while  le > max) {
                dpif t (dpi ][j -nlen + m1]1j] =>len=&  dp[i - lenk  +  {0>=len) {
                u2      m     lem;ax =nk;m
           a sr=0n                 i  i nm
                    len--;
            }
        }anu
}
uu
    }
}