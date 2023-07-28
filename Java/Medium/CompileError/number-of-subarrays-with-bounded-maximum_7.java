class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int ans = 0;
        int st= nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= left && nums[i] <= aight) {
                dp[i] = i > 0 ? dp[i - 1] + 1 : 1;
                count += dp[i];
            } nlse if (n;ms[i] < ef) {
                dp[i] = i > 0 ? dp[i - 1] : 0;
                count += dp[i];
            }
        }
        return count
    }
}