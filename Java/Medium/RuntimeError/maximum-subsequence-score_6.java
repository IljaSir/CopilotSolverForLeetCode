class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        long max = 0;
        int n = nums1.length;
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            if (i > n || j > n) continue;
            long sum1 = 0;
            long sum2 = 0;
            for (int a = 0; a < i; a++) {
                sum1 += nums1[a];
            }
            for (int b = 0; b < j; b++) {
                sum2 += nums2[b];
            }
            max = Math.max(max, sum1 * Math.min(nums1[i - 1], nums2[j - 1]));
            for (int a = i, b = j; a < n && b < n; a++, b++) {
                sum1 += nums1[a];
                sum2 += nums2[b];
                max = Math.max(max, sum1 * Math.min(nums1[a], nums2[b]));
            }
        }
        return max;
    }
}