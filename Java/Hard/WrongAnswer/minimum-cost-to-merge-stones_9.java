class Solution {
    public int mergeStones(int[] stones, int k) {
        
        int n = stones.length;
        if((n-1)%(k-1) != 0) return -1;
        int[] prefix = new int[n+1];
        for(int i=1; i<=n; i++) {
            prefix[i] = prefix[i-1] + stones[i-1];
        }
        int[][][] dp = new int[n][n][k+1];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int m=0; m<=k; m++) {
                    dp[i][j][m] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int m=1; m<=k; m++) {
                dp[i][i][m] = 0;
            }
        }
        for(int len=2; len<=n; len++) {
            for(int i=0; i<n-len+1; i++) {
                int j = i + len - 1;
                for(int m=2; m<=k; m++) {
                    for(int p=i; p<j; p+=m-1) {
                        dp[i][j][1] = Math.min(dp[i][j][1], dp[i][p][m] + dp[p+1][j][1]);
                    }
                }
                dp[i][j][1] += prefix[j+1] - prefix[i];
            }
        }
        return dp[0][n-1][1];
    }
}