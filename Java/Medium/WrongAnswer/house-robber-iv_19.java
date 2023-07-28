class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i < k; i++) {
            int[] ndp = new int[n];
            int min = Integer.MAX_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                min = Math.min(min, dp[j]);
                ndp[j] = min;
            }
            min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, dp[j]);
                ndp[j] = Math.max(ndp[j], min);
                if (j > 0) {
                    ndp[j] = Math.max(ndp[j], ndp[j - 1]);
                }
            }
            dp = ndp;
        }
        return dp[n - 1];
    }
}