class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        long[] dp = new long[n + 1];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) (nums1[i] - nums2[i]) * (nums1[i] - nums2[i]);
        }
        dp[0] = ans;
        for (int i = 0; i < n; i++) {
            ans -= (long) (nums1[i] - nums2[i]) * (nums1[i] - nums2[i]);
            dp[i + 1] = ans;
        }
        long res = dp[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (nums2[mid] <= nums1[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (l < n) {
                res = Math.min(res, dp[i] + (long) (nums1[i] - nums2[l]) * (nums1[i] - nums2[l]));
            }
            if (l > 0) {
                res = Math.min(res, dp[i] + (long) (nums2[l - 1] - nums1[i]) * (nums2[l - 1] - nums1[i]));
            }
        }
        return res;
    }
}