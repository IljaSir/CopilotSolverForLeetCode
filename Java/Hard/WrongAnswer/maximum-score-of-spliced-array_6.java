class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long[] max1 = new long[n + 1];
        long[] max2 = new long[n + 1];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums1[i];
            max1[i + 1] = Math.max(sum, max1[i]);
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums2[i];
            max2[i + 1] = Math.max(sum, max2[i]);
        }
        int i = 0, j = n;
        long res = 0;
        while (i <= n && j >= 0) {
            res = Math.max(res, max1[i] + max2[j]);
            if (i == n || j == 0) {
                break;
            }
            if (nums1[i] < nums2[j - 1]) {
                i++;
            } else {
                j--;
            }
        }
        return (int) (res % 1000000007);
    }
}