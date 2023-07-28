class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        long res = 0;
        int n = nums1.length;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums1[i] - nums2[i];
            b[i] = nums2[i] - nums1[i];
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + a[i - 1];
        }
        long[] sum2 = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum2[i] = sum2[i - 1] + b[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            res += (long) a[i - 1] * a[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            res += (long) b[i - 1] * b[i - 1];
        }
        long min = res;
        for (int i = 1; i <= n; i++) {
            long v = (long) a[i - 1] * (n - i) - (sum[n] - sum[i]);
            long v2 = (long) b[i - 1] * (n - i) - (sum2[n] - sum2[i]);
            if (k1 >= i) {
                min = Math.min(min, res - v - (long) a[i - 1] * a[i - 1] + (long) b[i - 1] * b[i - 1]);
            }
            if (k2 >= i) {
                min = Math.min(min, res - v2 - (long) a[i - 1] * a[i - 1] + (long) b[i - 1] * b[i - 1]);
            }
        }
        return min;
    }
}