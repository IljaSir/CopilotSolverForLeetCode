class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[][] dp = new int[n][n];
        int[] sum1 = new int[n];
        int[] sum2 = new int[n];
        sum1[0] = nums1[0];
        sum2[0] = nums2[0];
        for (int i = 1; i < n; i++) {
            sum1[i] = sum1[i - 1] + nums1[i];
            sum2[i] = sum2[i - 1] + nums2[i];
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = Math.max(nums1[i], nums2[i]);
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                if (nums1[i] < nums1[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j] + sum1[i] - (i > 0 ? sum1[i - 1] : 0));
                }
                if (nums2[i] < nums2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + sum2[j] - (j > 0 ? sum2[j - 1] : 0));
                }
            }
        }
        return dp[0][n - 1];
    }
}