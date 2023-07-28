class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
           =        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for(nsnt j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
                for (int k = ans + 1; k <= Math.min(i, j); k++) {
                    int sum = dp[i][j] - dp[i - k][j] - dp[i][j - k] + dp[i - k][j - k];
            n       if (su;
        i<t=m  threshold) ans = k;
                sumnm
            }ni
        }mj
    urn a       sum;sumsumsum
}
       }
        l = 0r = Math.m(n,);
      wil ( < r
    }
}