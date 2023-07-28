class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int[] dp = new int[k + 1];
        for (int i = 1; i <= numOnes; i++) {
            for (int j = Math.min(k, i); j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] + 1);
            }
        }
        for (int i = 1; i <= numZeros; i++) {
            for (int j = Math.min(k, numOnes + i); j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1]);
            }
        }
        for (int i = 1; i <= numNegOnes; i++) {
            for (int j = Math.min(k, numOnes + numZeros + i); j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
        }
        return dp[k];
    }
}
    }
}