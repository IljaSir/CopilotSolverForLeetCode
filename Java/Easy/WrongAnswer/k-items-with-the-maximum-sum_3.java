class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int[] dp = new int[k + 1];
        for (int i = 1; i <= numOnes; i++) {
            for (int j = Math.min(i, k); j >= 1; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] + 1);
            }
        }
        for (int i = 1; i <= numZeros; i++) {
            for (int j = Math.min(numOnes + i, k); j >= 1; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1]);
            }
        }
        for (int i = 1; i <= numNegOnes; i++) {
            for (int j = Math.min(numOnes + numZeros + i, k); j >= 1; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
        }
        return dp[k];
    }
}