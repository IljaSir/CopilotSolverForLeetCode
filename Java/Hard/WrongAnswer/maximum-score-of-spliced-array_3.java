class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = nums2[i] - nums1[i];
        }
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + diff[i - 1];
        }
        long res = 0;
        for (int i = 0; i <= n; i++) {
            res = Math.max(res, prefix[i] + prefix[n] - prefix[i]);
        }
        for (int i = 0; i < n; i++) {
            if (diff[i] < 0) {
                int j = i;
                while (j < n && diff[j] < 0) {
                    j++;
                }
                res = Math.max(res, prefix[i] + prefix[n] - prefix[j]);
                i = j;
            }
        }
        for (int i = 0; i < n; i++) {
            if (diff[i] > 0) {
                int j = i;
                while (j < n && diff[j] > 0) {
                    j++;
                }
                res = Math.max(res, prefix[i] + prefix[n] - prefix[j]);
                i = j;
            }
        }
        return (int) (res + Arrays.stream(nums1).sum());
    }
}