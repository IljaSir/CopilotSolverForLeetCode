class Solution {
    public int totalSteps(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            if (nums[i] < nums[i - 1]) {
                int diff = nums[i - 1] - nums[i];
                nums[i] = nums[i - 1];
                dp[i] += diff;
            }
        }
        return dp[n - 1];
    }
}