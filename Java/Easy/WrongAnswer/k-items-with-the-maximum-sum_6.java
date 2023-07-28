class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            int max = Integer.MIN_VALUE;
            if (i <= numOnes) {
                max = Math.max(max, dp[i - 1] + 1);
            }
            if (i <= numZeros) {
                max = Math.max(max, dp[i - 1]);
            }
            if (i <= numNegOnes) {
                max = Math.max(max, dp[i - 1] - 1);
            }
            dp[i] = max;
        }
        return dp[k];
    }
}