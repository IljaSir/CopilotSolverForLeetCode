class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        long[] dp = new long[k + 1];
        Arrays.fill(dp, Long.MIN_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int[] nums = {nums1[i], nums2[i]};
            Arrays.sort(nums);
            for (int j = k; j >= 0; j--) {
                if (j > 0) {
                    dp[j] = Math.max(dp[j], dp[j - 1] + (long) nums[0]);
                }
                if (j >= i + 1) {
                    dp[j] = Math.max(dp[j], dp[j - i - 1] + (long) nums[1]);
                }
            }
        }
        return dp[k];
    }
}