class Solution {
    public int splitArray(int[] nums, int k) {
        
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        long[] dp = new long[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = sums[n] - sums[i];
        }
        for (int i = 0; i < k - 1; ++i) {
            long[] ndp = new long[n];
            Arrays.fill(ndp, Integer.MAX_VALUE);
            for (int j = 0; j < n; ++j) {
                for (int l = j + 1; l < n; ++l) {
                    long cur = Math.max(dp[l], sums[l] - sums[j]);
                    ndp[j] = Math.min(ndp[j], cur);
                }
            }
            dp = ndp;
        }
        return (int)dp[0];
    }
}