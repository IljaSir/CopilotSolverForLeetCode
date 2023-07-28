class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int[][][] dp = new int[numOnes + 1][numZeros + 1][numNegOnes + 1];
        for (int i = 0; i <= numOnes; i++) {
            for (int j = 0; j <= numZeros; j++) {
                for (int l = 0; l <= numNegOnes; l++) {
                    for (int m = 0; m <= k; m++) {
                        if (m == 0) {
                            dp[i][j][l] = 0;
                            continue;
                        }
                        int max = dp[i][j][l];
                        if (i > 0) {
                            max = Math.max(max, dp[i - 1][j][l] + 1);
                        }
                        if (j > 0) {
                            max = Math.max(max, dp[i][j - 1][l]);
                        }
                        if (l > 0) {
                            max = Math.max(max, dp[i][j][l - 1] - 1);
                        }
                        dp[i][j][l] = max;
                    }
                }
            }
        }
        return dp[numOnes][numZeros][numNegOnes];
    }
}