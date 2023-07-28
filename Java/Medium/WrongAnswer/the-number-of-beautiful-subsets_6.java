class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] dp = new int[max + 1];
        for (int i = 0; i < n; i++) {
            dp[nums[i]]++;
        }
        int[] dp2 = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            dp2[i] = dp[i] + dp2[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            ans += dp[i] * (dp2[max] - dp2[Math.max(0, i - k - 1)]);
            if (k != 0) {
                ans += dp[i] * (dp2[Math.min(max, i + k - 1)] - dp2[i]);
            }
        }
        return ans;
    }
}