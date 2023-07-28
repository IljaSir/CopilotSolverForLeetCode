class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp = new int[n];
        dp[0] = Math.max(nums1[0], nums2[0]);
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(nums1[i], nums2[i]));
            if (nums1[i] > nums2[i]) {
                nums1[i] = nums2[i];
            }
        }
        for (int i = 1; i < n; i++) {
            nums1[i] += nums1[i - 1];
        }
        int res = nums1[n - 1];
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i] + nums1[n - 1] - nums1[i]);
        }
        return res;
    }
}