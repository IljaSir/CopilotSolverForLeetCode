class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int[][][] dp = new int[numOnes+1][numZeros+1][numNegOnes+1];
        for (int i = 0; i <= numOnes; i++) {
            for (int j = 0; j <= numZeros; j++) {
                for (int m = 0; m <= numNegOnes; m++) {
                    dp[i][j][m] = Math.max(i, Math.max(j, m));
                }
            }
        }
        for (int i = 0; i <= numOnes; i++) {
            for (int j = 0; j <= numZeros; j++) {
                for (int m = 0; m <= numNegOnes; m++) {
                    if (i > 0) dp[i][j][m] = Math.max(dp[i][j][m], dp[i-1][j][m]+1);
                    if (j > 0) dp[i][j][m] = Math.max(dp[i][j][m], dp[i][j-1][m]);
                    if (m > 0) dp[i][j][m] = Math.max(dp[i][j][m], dp[i][j][m-1]-1);
                }
            }
        }
        return dp[numOnes][numZeros][numNegOnes];
    }
}