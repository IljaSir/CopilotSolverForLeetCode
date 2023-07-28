class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        long[] dp = new long[k + 1];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int[] nums = nums1[i] > nums2[i] ? nums1 : nums2;
            int[] other = nums1[i] > nums2[i] ? nums2 : nums1;
            long[] cur = new long[k + 1];
            Arrays.fill(cur, Long.MIN_VALUE);
            for (int j = 0; j <= k; j++) {
                if (j > 0 && nums[i] >= other[i]) {
                    cur[j] = Math.max(cur[j], dp[j - 1] + nums[i]);
                }
                if (j < k) {
                    cur[j] = Math.max(cur[j], dp[j] + other[i]);
                }
            }
            dp = cur;
        }
        long ans = 0;
        for (long x : dp) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}