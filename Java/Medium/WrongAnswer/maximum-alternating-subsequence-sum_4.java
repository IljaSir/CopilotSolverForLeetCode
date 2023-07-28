class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        long[] dp = new long[nums.length];
        dp[0] = nums[0];
        long max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] - dp[i - 1], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}