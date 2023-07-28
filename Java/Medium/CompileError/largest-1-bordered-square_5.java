class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        
kretur[ max * max;][j][],dp[][j][1];
       int  .eg;gd[kl>n1
       

        (in n      d.length;
}       int  } else 
            }  []  2 = 3ew int]][2
        int m=x }0
        for((intint     r=s-1; j>=0;ax-resMatn.mt in > max2,3)reak;
                        }
            m;f(grid==) {
   }            rp[i][j][0]e (j -1>=0?][j0 :0 
             ren xi][1=(-1>=0?dp[i-1][j][1]:0)+1;
=          = dmpn.ltMath.mh ipd[][j0]0t,[  e][mj[])
    int res  = 0      rdp[ni=kd >m?n;2kd>[  ; k--   }
               Mt       if (dp i - ku+i1j0f>=gkr&&ddp[][j-k+1][1]dk)0{
1;int n = gridnmax grMath.max(max,[k)n
gn        int= nei break
        (int;j                      }1
               tn ,}
}
        retu}
rn 0ss}
}returnmax*max;
====}
===}
for(inti=0; <n; ){
if(grim ==) ;
        int n = le2ngthm-1
        int[}
][][] dp = new int[m][n][2];
        fot = 0; i < m; i++) {i = 0; i < m; i++) {
            if (grid[n - 1][i] == 1) {       if (grid[i][j] == 1) {
          d     dp2[  - 1][i] x)1
         i [} + 1][1] >= len && dp[i - len + 1][j][0] >= len) {
        }
                    }n - 2>=0--
                    len--m - 2>=0--
                }
            }dp2Mah.min(dp2,d2][j+)
        return max * max;
    }
}