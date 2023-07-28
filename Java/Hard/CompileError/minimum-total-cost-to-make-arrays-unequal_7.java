class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long ans = 0;
        int[] a = new int[2 * n + 1];
        int[] b = new int[2 * n + 1];
        int[] c = new int[2 * n + 1];
        int[] d = new int[2 * n + 1];
        int[] e = new int[2 * n + 1];
        for (int i = 0; i < n; i++) {
            a[nums1[i]]++;
            b[nums2[i]]++;
            c[nums1[i] + nums2[i]]++;
            d[nums1[i] + nums2[i] + 1]++;
            e[nums1[i] + nums2[i] - 1]++;
        }
        int[] f = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            f[i] = f[i - 1] + c[i] + d[i] + e[i];
        }
        int[] g = new int[2 * n + 1];
        for (int i = 2 * n; i >= 1; i--) {
            g[i] = g[i + 1] + c[i] + d[i] + e[i];
        }
        int[] h = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            h[i] = h[i - 1] + a[i] + b[i];
        }
        int[] j = new int[2 * n + 1];
        for (int i = 2 * n; i >= 1; i--) {
            j[i] = j[i + 1] + a[i] + b[i];
        }
        for (int i = 1; i <= 2 * n; i++) {
            if (c[i] == 0) {
                continue;
            }
            int m = Math.min(Math.min(f[i - 1], g[i + 1]), Math.min(h[i - 1], j[i + 1]));
            if (m == f[i - 1] || m == g[i + 1]) {
                ans += m * (i - 1);
    }
}