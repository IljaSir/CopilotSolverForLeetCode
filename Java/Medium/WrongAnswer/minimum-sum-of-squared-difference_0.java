class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        int n = nums1.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; ++i) {
            diff[i] = nums1[i] - nums2[i];
        }
        Arrays.sort(diff);
        long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += diff[i] * diff[i];
        }
        long res = sum;
        for (int i = 0; i < n; ++i) {
            sum -= diff[i] * diff[i];
            int d = k1 - i;
            if (d > 0) {
                sum += d * d;
            }
            d = k2 - (n - 1 - i);
            if (d > 0) {
                sum += d * d;
            }
            res = Math.min(res, sum);
        }
        return res;
    }
}