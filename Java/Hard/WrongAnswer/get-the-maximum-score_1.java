class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        
        int MOD = 1000000007;
        int i = 0, j = 0, sum1 = 0, sum2 = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                sum1 += nums1[i++];
            } else if (j < nums2.length && (i == nums1.length || nums1[i] > nums2[j])) {
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