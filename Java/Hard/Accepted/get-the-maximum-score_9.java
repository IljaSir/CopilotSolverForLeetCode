class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        
        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0, mod = (long)1e9 + 7;
        while(i < nums1.length || j < nums2.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    sum1 += nums1[i++];
                } else if (nums1[i] > nums2[j]) {
                    sum2 += nums2[j++];
                } else {
                    sum1 = sum2 = Math.max(sum1, sum2) + nums1[i];
                    i++;
                    j++;
                }
            } else if (i < nums1.length) {
                sum1 += nums1[i++];
            } else {
                sum2 += nums2[j++];
            }
        }
        return (int)(Math.max(sum1, sum2) % mod);
    }
}