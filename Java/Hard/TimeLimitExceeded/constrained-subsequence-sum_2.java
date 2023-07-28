class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            for (int j = Math.max(0, i - k); j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}