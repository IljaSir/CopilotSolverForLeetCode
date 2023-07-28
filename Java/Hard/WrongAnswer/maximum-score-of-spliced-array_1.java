class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] sum1 = new int[n + 1];
        int[] sum2 = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            sum1[i + 1] = sum1[i] + nums1[i];
            sum2[i + 1] = sum2[i] + nums2[i];
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            if (nums1[i] < nums2[i]) {
                int j = Arrays.binarySearch(nums1, i + 1, n, nums2[i]);
                if (j < 0) {
                    j = -j - 1;
                }
                dp[j] = Math.max(dp[j], dp[i] + sum1[i] + sum2[n] - sum2[j]);
            } else if (nums1[i] > nums2[i]) {
                int j = Arrays.binarySearch(nums2, i + 1, n, nums1[i]);
                if (j < 0) {
                    j = -j - 1;
                }
                dp[j] = Math.max(dp[j], dp[i] + sum2[i] + sum1[n] - sum1[j]);
            }
        }
        return dp[n];
    }
}