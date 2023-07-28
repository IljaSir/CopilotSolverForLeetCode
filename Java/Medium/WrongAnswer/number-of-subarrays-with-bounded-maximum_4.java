class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int count = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                dp[i] = i > 0 ? dp[i - 1] + 1 : 1;
                count += dp[i];
            } else if (nums[i] < left) {
                dp[i] = i > 0 ? dp[i - 1] : 0;
                count += dp[i];
            }
        }
        return count;
    }
}