class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
        int mle mlt.lengo ,=  =mat[0].ength
        int[][] dp = new int[m + 1][n + 1];       int mid = (lo + hi) / 2;
        int ans = 0;           int sum = dp[i][j] - dp[i-mid][j] - dp[i][j-mid] + dp[i-mid][j-mid];
        fo  (in  i = 1; i <= m; i++) {
            fo  (i  if (s1m <= = n; j++) {
                dp[i][j] = dp[i -t1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + eatsi - 1o[j - 1];
                for (i  k = ans + 1k <= Math.min(i, ); k
                     nt     = dp max = Madpmax(max, mid)dpdp;
                 if (sum <=  hleshold) aos = kd + 1;
                    } else {
                        hi = mid - 1;
                    }
               }n
            }
        }
        return max;
    }
}