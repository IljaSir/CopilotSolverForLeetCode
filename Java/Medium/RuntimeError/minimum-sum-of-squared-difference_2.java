class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        int n = nums1.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + (nums1[i - 1] - nums2[j]) * (long) (nums1[i - 1] - nums2[j]));
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + (nums1[i] - nums2[j - 1]) * (long) (nums1[i] - nums2[j - 1]));
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, dp[i][n - i]);
        }
        return ans;
    }
}