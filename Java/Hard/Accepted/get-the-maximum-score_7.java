class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        
        long MOD = 1000000007;
        long sum1 = 0;
        long sum2 = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                sum1 += nums1[i++];
            } else if (j < nums2.length && (i == nums1.length || nums2[j] < nums1[i])) {
                sum2 += nums2[j++];
            } else {
                sum1 = sum2 = Math.max(sum1, sum2) + nums1[i];
                i++;
                j++;
            }
        }
        return (int) (Math.max(sum1, sum2) % MOD);
    }
}