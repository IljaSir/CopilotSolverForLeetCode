class Solution {
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] newNums = new int[n + 2];
        for (int i = 0; i < n; i++) newNums[i + 1] = nums[i];
        newNums[0] = newNums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}