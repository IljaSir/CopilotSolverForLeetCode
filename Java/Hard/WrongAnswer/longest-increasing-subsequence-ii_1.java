class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (Math.abs(nums[i] - nums[j]) <= k) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}