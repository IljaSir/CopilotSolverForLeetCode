class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        int n = nums1.length;
        long[][] dp = new long[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.abs(nums1[i] - nums2[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            Arrays.sort(dp[i]);
        }
        long[][] minSum = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = dp[i][j] + (j == 0 ? 0 : minSum[i][j - 1]);
            }
        }
        long[][] minSum2 = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum2[i][j] = dp[i][j] * (j + 1) - minSum[i][j];
            }
        }
        long[][] minSum3 = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum3[i][j] = minSum2[i][j] + (j == 0 ? 0 : minSum3[i][j - 1]);
            }
        }
        long[][] minSum4 = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum4[i][j] = dp[i][j] * (j + 1) - minSum2[i][j];
            }
        }
        long[][] minSum5 = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum5[i][j] = minSum4[i][j]
    }
}