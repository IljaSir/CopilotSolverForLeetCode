class Solution {
    public long minimumReplacement(int[] nums) {
        
        int n = nums.length;
        long[] dp = new long[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.min(dp[i - 1], dp[i]);
            }
            if (i > 1 && nums[i] > nums[i - 2]) {
                dp[i] = Math.min(dp[i - 2] + 1, dp[i]);
            }
        }
        return dp[n - 1];
    }
}