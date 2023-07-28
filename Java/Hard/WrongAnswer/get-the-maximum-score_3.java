class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int sum1 = 0;
        int sum2 = 0;
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                sum1 += nums1[i];
                sum2 += nums2[j];
                sum1 = sum1 > sum2 ? sum1 : sum2;
                sum2 = sum1;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                sum1 += nums1[i];
                i++;
            } else {
                sum2 += nums2[j];
                j++;
            }
        }
        while (i < n) {
            sum1 += nums1[i];
            i++;
        }
        while (j < m) {
            sum2 += nums2[j];
            j++;
        }
        return Math.max(sum1, sum2) % 1000000007;
    }
}