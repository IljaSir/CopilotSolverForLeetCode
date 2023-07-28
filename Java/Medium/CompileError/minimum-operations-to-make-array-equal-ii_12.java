class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        int m = nums2.length;
        if (n * 6 < k || m * 6 < k) {
            return -1;
        }
        int[] sum1 = new int[n + 1];
        int[] sum2 = new int[m + 1];
        for (int i = 0; i < n; i++) {
            sum1[i + 1] = sum1[i] + nums1[i];
        }
        for (int i = 0; i < m; i++) {
            sum2[i + 1] = sum2[i] + nums2[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int target = k - i;
            if (target < 0 || target > m || target % 6 != 0) {
                continue;
            }
            target /= 6;
            int j = lowerBound(sum2, sum2[m] - target);
            ans = Math.min(ans, Math.abs(sum1[i] - (sum2[m] - sum2[j])));
            if (j > 0i <= 6; i++) {
            for (int j = k; j >= 0; Math.abj(s--1[i] - (sum2[m] - sum2[j - 1]))) {
             
        }
        return ans;
    }

    public int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}