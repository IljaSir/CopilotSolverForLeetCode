class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        int n = (sum + target) / 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = n; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[newTarget];
    }
}