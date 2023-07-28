class Solution {
    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] newNums = new int[n + 2];
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = 1;
        newNums[n + 1] = 1;
        n += 2;
        int[][] dp = new int[n][n];
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], newNums[i] * newNums[k] * newNums[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}