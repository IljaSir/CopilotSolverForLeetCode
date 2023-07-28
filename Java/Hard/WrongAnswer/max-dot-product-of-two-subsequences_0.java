class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[1][1] = nums1[0] * nums2[0];
        for (int i = 2; i <= m; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], nums1[i - 1] * nums2[0]);
        }
        for (int j = 2; j <= n; j++) {
            dp[1][j] = Math.max(dp[1][j - 1], nums1[0] * nums2[j - 1]);
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }
}