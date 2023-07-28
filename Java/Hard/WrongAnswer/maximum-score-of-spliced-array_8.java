class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] dp = new int[n + 1];
        int[] sum = new int[n + 1];
        int[] dp2 = new int[n + 1];
        int[] sum2 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums1[i];
            sum2[i + 1] = sum2[i] + nums2[i];
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], sum[i]);
            dp2[i] = Math.max(dp2[i - 1], sum2[i]);
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int j = n - i;
            ans = Math.max(ans, Math.max(dp[i] + sum2[j], dp2[i] + sum[j]));
        }
        return ans;
    }
}