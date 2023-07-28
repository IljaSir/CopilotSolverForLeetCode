class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp = new int[n + 1];
        int[][] dp2 = new int[n + 1][2];
        int[] dp3 = new int[n + 1];
        int[] dp4 = new int[n + 1];
        dp[0] = nums1[0];
        dp2[0][0] = nums1[0];
        dp4[0] = nums1[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + nums1[i];
            dp2[i][0] = Math.max(dp2[i - 1][0], dp[i]);
            dp4[i] = dp4[i - 1] + nums1[i];
        }
        dp3[0] = nums2[0];
        dp2[0][1] = nums2[0];
        for (int i = 1; i < n; i++) {
            dp3[i] = dp3[i - 1] + nums2[i];
            dp2[i][1] = Math.max(dp2[i - 1][1], dp3[i]);
        }
        int max = dp2[n - 1][0] + dp3[n - 1];
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, dp4[i] + dp2[n - 1][1] - dp2[i][1]);
        }
        return max;
    }
}