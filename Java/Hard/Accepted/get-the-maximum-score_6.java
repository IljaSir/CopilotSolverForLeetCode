class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0, res = 0;
        while (i < n1 || j < n2) {
            if (i < n1 && (j == n2 || nums1[i] < nums2[j])) {
                sum1 += nums1[i++];
            } else if (j < n2 && (i == n1 || nums1[i] > nums2[j])) {
                sum2 += nums2[j++];
            } else {
                res += Math.max(sum1, sum2) + nums1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        res += Math.max(sum1, sum2);
        return (int) (res % 1000000007);
    }
}