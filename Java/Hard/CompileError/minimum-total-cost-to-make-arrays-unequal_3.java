class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = dp[i][2] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[0][2] = 1;
        for (int i = 1; i < n; i++) {
            if (nums1[i] != nums1[i - 1]) {
                dp[i][0] = dp[i - 1][0];
            }
            if (nums1[i] != nums2[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
            }
            if (nums1[i] != nums1[i - 1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][2]);
            }
            if (nums2[i] != nums1[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
            }
            if (nums2[i] != nums2[i - 1]) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
            }
            if (nums2[i] != nums1[i - 1]) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][2] + 1);
            }
            if (nums1[i] != nums2[i - 1]) {
                dp[i][2] = dp[i - 1][0] + 1;
            }
            if (nums1[i] != nums1[i - 1]) {
                dp[i][2] = Math.min(dp[i][2], dp[i - 1][1] + 1);
            }
            if (nums1[i] != nums2[i - 1]) {
                dp[i][2] = Math.min(dp[i][2], dp[i - 1][2] + 1);
            }
        }
        long result = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
    }
}