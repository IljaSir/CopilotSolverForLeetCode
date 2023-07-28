class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        
        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0, ans = 0;
        int mod = 1000000007;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                sum1 += nums1[i++];
            } else if (j < nums2.length && (i == nums1.length || nums1[i] > nums2[j])) {
                sum2 += nums2[j++];
            } else {
                ans += Math.max(sum1, sum2) + nums1[i];
                sum1 = sum2 = 0;
                i++;
                j++;
            }
        }
        ans += Math.max(sum1, sum2);
        return (int) (ans % mod);
    }
}