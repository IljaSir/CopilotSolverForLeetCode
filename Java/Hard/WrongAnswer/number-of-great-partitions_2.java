class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n + 1][k];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - nums[i - 1]]) % 1000000007;
                }
            }
        }
        return dp[n][k - 1];
    }
}