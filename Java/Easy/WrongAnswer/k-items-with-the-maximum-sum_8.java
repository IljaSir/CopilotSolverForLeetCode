class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int[] nums = new int[]{numOnes, numZeros, numNegOnes};
        int[] values = new int[]{1, 0, -1};
        int[][] dp = new int[4][51];
        for(int i = 1; i <= 3; i++) {
            for(int j = 1; j <= 50; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i - 1]] + values[i - 1] * nums[i - 1]);
                }
            }
        }
        return dp[3][k];
    }
}