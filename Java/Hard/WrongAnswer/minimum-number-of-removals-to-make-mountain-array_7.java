class Solution {
    public int minimumMountainRemovals(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
            ans = Math.max(ans, dp2[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (dp[i] > 1 && dp2[i] > 1) {
                ans = Math.max(ans, dp[i] + dp2[i] - 1);
            }
        }
        return n - ans;
    }
}