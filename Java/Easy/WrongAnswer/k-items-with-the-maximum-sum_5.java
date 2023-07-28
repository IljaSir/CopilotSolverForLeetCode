class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int[] dp = new int[k + 1];
        for (int i = 0; i < k; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < numOnes; i++) {
            for (int j = Math.min(k, i + 1); j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] + 1);
            }
        }
        for (int i = 0; i < numZeros; i++) {
            for (int j = Math.min(k, i + 1); j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1]);
            }
        }
        for (int i = 0; i < numNegOnes; i++) {
            for (int j = Math.min(k, i + 1); j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
        }
        return dp[k];
    }
}