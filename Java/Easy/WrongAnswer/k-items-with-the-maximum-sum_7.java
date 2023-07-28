class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int[] nums = new int[]{numOnes, numZeros, numNegOnes};
        int[] values = new int[]{1, 0, -1};
        int[][] dp = new int[nums.length][k + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 0) {
                    dp[i][j] = Math.min(nums[i], j) * values[i];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + values[i]);
                }
            }
        }
        return dp[nums.length - 1][k];
    }
}