class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        int neg = (sum - target) / 2;
        int[][] dp = new int[n + 1][neg + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][neg];
    }
}