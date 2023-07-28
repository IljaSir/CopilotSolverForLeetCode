class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            long tmp = 0;
            int j = k - i;
            if (j > n) {
                break;
            }
            int[] a = new int[i];
            int[] b = new int[j];
            for (int p = 0; p < i; p++) {
                a[p] = nums1[p];
            }
            for (int p = 0; p < j; p++) {
                b[p] = nums2[p];
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for (int p = 0; p < j; p++) {
                if (p < i) {
                    tmp += a[p];
                }
                tmp += b[j - p - 1];
            }
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}