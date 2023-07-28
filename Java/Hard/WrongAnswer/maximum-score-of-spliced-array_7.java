class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Math.max(nums1[i], nums2[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[i] = sum;
        }
        int ans = sum;
        for (int i = 0; i < n; i++) {
            if (nums1[i] < nums2[i]) {
                ans = Math.max(ans, dp[i] - nums1[i] + nums2[i]);
            }
        }
        return ans;
    }
}