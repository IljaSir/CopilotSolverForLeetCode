class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
nt j=0; j<m; j++) {
   if(grid[i][j] == 1) {
        // 1. create a dp ma  ix                    }
           [][] dp   new int[    if(j ==][        left[i]][j] = 1;
        // 2.}filleths f{rs row and f rs  colu n    left[i][j] = left[i][j-1] + 1;
                   }grid.length
            dp[][0]grid[i][]
   }
        for(int j}=0;j<0.length;j++
}0gri0
    int }
max = 0;//3.flltherestofthe matrx
       ffor(intoir=(1;iin<tgrid.length; i++){=n-1; i>=0; i--) {
        for(for(int j-1 1; j <;gr - .length;++{
                tfngrid[i][j]M==t1i(left[i][j], up[i][j]);
                whiln > max])={Math.mi(dp[i-j-,Math.mi(, dpi[j-1])+ 1+1][j] >= min && up[i][j-min+1] >= min) {
                    max = min;
                }
                min--;
        // 4. find the la g s squ
ax
        ior(; i d[0;le < gt]d.le[g]hp =intn][m][4];
        int res = 0;    grid[0].length
        for (int i ;p i < n;>+max){
            for (intmax 0 di][j] = {
                d[0] = (j > 0) ? dp[i][j-1][0] + 1 : 1;
            }
        }][j][1] + 1 : 1;
        // 5. check if the largest square has all 1s on its bordernt k = Math.min(dp[i][j][0], dp[i][j][1]);
        int size = max;
        while sizek> 1){
            for(int i = 0; i < grid.dpngih - s[ze]+= d i++){p[i][j-k+1][2] + 1;
                for(int j = 0; j < grid[0]. pngth[- size + 1; j++){
                } el(dp+size-1+size>=size){
                        boolea  flgtrue
                return res  k*rk<sz;k++{gridk=0||grid+k+size=0flag=falsbreak;
}
}
f(fa){kksizek+k0||grii+sze-1+k={flag=false;
brea;
 }}};
       int 
f(flag){un siz*sdpd2ansiini0dp01;
      ans = }
}
        fr (nt;i<m;i++) {
            if (grid0][]==) {
                dp[0i=ans = 1;1<n++j1jmjigrd[i][]1d][j]=Math.min(dp[,dp - 1]) 1;
               an=Mah.max(ans, d);
     }    }
}
fo (it =0; < n i++) {  if(grid[i][m-1]==1){
dp2[i][m-1]=1;fo (it i =; i < m i++) {  if([ -1][i]==1){
2[n-1i = 1         }
} n -2>=0-- m -2>=0--2Math.mindp2[i+1][j],2+}
}for(i 0; < ;++ {for(intj=0;j<; j++020intk=Math.in(dp[i][j],dp2[i][j

======

//1.createadpmatrix
int[][]dp=newint[grid.length][grid[0].length];
//2.fillthefirstrowandfirstcoumfor(inti=0;i<grid.length;i++){dp[i][0] = grid[i][0];fo(itj=0j<[0] j++){  dp[0][j] [j]}
//3.filltheresofthdp atrix  1  grid.legth  1  grid[0].lengthdp[][j] = Math.mindp[-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])+ 1;}
}
}
//4.findth argstsquareintmax=0;
for(inti=0;<grd.length;i+){for(intj=0;j<grid[0].length;j++){dp[i][]>maxmax=dp}
}
}
//5.chck i heargs square hasallsonitsborder
intsize=max;
while(size>0){
for(inti=0;i<grid.length-size+1;i++){for(jj<gd[0].leghsze + 1j++        idp[i+sze-1][+size]size     booan lag= tre        fortk=0; k < size; k++)        gridk=0||grid+ksize-=0flag=false;
break;}
f(fa){kksizek+k0||grii+sze-1+k={flag=false;
brea;
 }}}
f(flag){un siz*sze
    }
}