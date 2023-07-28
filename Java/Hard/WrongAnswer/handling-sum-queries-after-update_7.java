class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        
        int n = nums1.length;
        int q = queries.length;
        long[] res = new long[q];
        long[] sum = new long[n];
        long[] flip = new long[n];
        for (int i = 0; i < n; i++) {
            sum[i] = nums2[i];
            flip[i] = nums1[i] * nums2[i];
        }
        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1];
            flip[i] += flip[i - 1];
        }
        int idx = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                int l = query[1];
                int r = query[2];
                if (l > 0) {
                    sum[l - 1] -= nums1[l - 1] * nums2[l - 1];
                    flip[l - 1] -= nums1[l - 1] * nums2[l - 1];
                }
                sum[r] += nums1[r] * nums2[r];
                flip[r] += nums1[r] * nums2[r];
                for (int i = l; i <= r; i++) {
                    nums1[i] = 1 - nums1[i];
                }
            } else if (query[0] == 2) {
                int p = query[1];
                for (int i = 0; i < n; i++) {
                    sum[i] += nums1[i] * p;
                    flip[i] += nums1[i] * p;
                }
            } else {
                int l = query[1];
                int r = query[2];
                if (l > 0) {
                    res[idx++] = flip[r] - flip[l - 1];
                } else {
                    res[idx++] = flip[r];
                }
            }
        }
        return res;
    }
}