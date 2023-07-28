class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long[][] dp = new long[n][3];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = dp[i][2] = 1000000000;
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            if (nums1[i] != nums1[i - 1] && nums1[i] != nums2[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
            }
            if (nums1[i] != nums1[i - 1] && nums1[i] != nums2[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
            }
            if (nums1[i] != nums1[i - 1] && nums1[i] != nums2[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][2]);
            }
            if (nums2[i] != nums1[i - 1] && nums2[i] != nums2[i - 1]) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + i);
            }
            if (nums2[i] != nums1[i - 1] && nums2[i] != nums2[i - 1]) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + i);
            }
            if (nums2[i] != nums1[i - 1] && nums2[i] != nums2[i - 1]) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][2] + i);
            }
            if (nums1[i] != nums1[i - 1] && nums2[i] != nums2[i - 1]) {
                dp[i][2] = Math.min(dp[i][2], dp[i - 1][0] + i);
            }
            if (nums1
    }
}