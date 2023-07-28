class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums1[i] - 1;
            b[i] = nums2[i] - 1;
            c[i] = Math.min(a[i], b[i]);
            d[i] = Math.max(a[i], b[i]);
        }
        Arrays.sort(c);
        Arrays.sort(d);
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long cur = 0;
            for (int j = 0; j < n; j++) {
                if (j < i) {
                    cur += c[j];
                } else {
                    cur += d[j] - i;
                }
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}