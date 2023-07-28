class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        long[] dp = new long[k+1];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            long[] next = new long[k+1];
            Arrays.fill(next, Long.MIN_VALUE);
            for (int j = 0; j <= k; j++) {
                if (j > 0 && nums1[i] < nums2[i]) {
                    next[j] = Math.max(next[j], dp[j-1] + nums1[i]);
                }
                if (k-j <= n-i-1) {
                    next[j] = Math.max(next[j], dp[j] + nums2[i]);
                }
            }
            dp = next;
        }
        long ans = Long.MIN_VALUE;
        for (long x: dp) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}