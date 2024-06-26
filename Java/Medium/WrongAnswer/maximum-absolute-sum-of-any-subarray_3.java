class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = dp[0];
        int min = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
            min = Math.min(min, dp[i]);
        }
        return max - min;
    }
}