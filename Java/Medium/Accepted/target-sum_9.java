class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > Math.abs(sum)) {
            return 0;
        }
        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][sum + nums[0]] = 1;
        dp[0][sum - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (dp[i - 1][j + sum] > 0) {
                    dp[i][j + sum + nums[i]] += dp[i - 1][j + sum];
                    dp[i][j + sum - nums[i]] += dp[i - 1][j + sum];
                }
            }
        }
        return dp[nums.length - 1][target + sum];
    }
}