class Solution {
    public int minOperations(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + 1 - nums[i], 0) + dp[i - 1];
            nums[i] = Math.max(nums[i - 1] + 1, nums[i]);
        }
        return dp[n - 1];
    }
}