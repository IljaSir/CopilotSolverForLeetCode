class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0] >= left && nums[0] <= right ? 1 : 0;
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                dp[i] = 1 + dp[i - 1];
            } else if (nums[i] < left) {
                dp[i] = dp[i - 1];
            }
            res += dp[i];
        }
        return res;
    }
}