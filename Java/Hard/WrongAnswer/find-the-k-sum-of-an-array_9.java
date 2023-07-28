class Solution {
    public long kSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i + 1] = a[i] + nums[i];
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = a[i];
        }
        for (int i = 2; i <= k; i++) {
            long[] ndp = new long[n + 1];
            ndp[0] = 0;
            long max = Long.MIN_VALUE;
            for (int j = 1; j <= n; j++) {
                max = Math.max(max, dp[j - 1]);
                ndp[j] = Math.max(ndp[j - 1], a[j] + max);
            }
            dp = ndp;
        }
        return dp[n];
    }
}