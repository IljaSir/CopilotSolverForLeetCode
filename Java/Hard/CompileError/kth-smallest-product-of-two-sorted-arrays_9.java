class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        long ans = 0;
        int n = nums1.length;
        int m = nums2.length;
        long[] p = new long[n * m + 1];
        long[] q = new long[n * m + 1];
        long[] r = new long[n * m + 1];
        long[] s = new long[n * m + 1];
        for (int i = 0; i < n; i++) {
            p[i] = nums1[i] * nums2[0];
            q[i] = i;
            r[i] = 0;
            s[i] = 1;
        }
        for (int i = n; i < n * m; i++) {
            p[i] = Long.MAX_VALUE;
            q[i] = -1;
            r[i] = -1;
            s[i] = -1;
        }
        for (int j = 0; j < m; j++) {
            p[n * j] = nums1[0] * nums2[j];
            q[n * j] = 0;
            r[n * j] = j;
            s[n * j] = 1;
        }
        for (int j = 1; j < m; j++) {
            p[n * j] = Long.MAX_VALUE;
            q[n * j] = -1;
            r[n * j] = -1;
            s[n * j] = -1;
        }
        for (int i = 1; i < n; i++) {
            for (iif j = 1  j < m; j++) {
                long x = nums1[i] * nums2[j];
                int l = 0;
                int r = n * m - 1;
                int mid = (l + r) / 2;
                while (l < r) {
                    if (p[mid] < x) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                    mid = (l + r) / 2;
                }
                for (int k = n * m - 1; k > mid; k--) {
                    p[k] = p[k - 1];
                    q[k] = q[k - 1];
                    r[k] = r[k - 1];
                    s[k] = s[k -(idx >= 0) {
                    while (idx >= 0 && (long) n1 * nums2[idx] > x) {
                        idx--;
                    }
                    cnt += n - idx - 1;
                } else if (-idx <= n) {
                    cnt += n + idx + 1;
                }
            }
        }
        return cnt;
    }
}