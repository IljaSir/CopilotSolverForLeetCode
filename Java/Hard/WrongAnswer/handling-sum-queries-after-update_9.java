class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        
        int n = nums1.length;
        int q = queries.length;
        long[] res = new long[q];
        long[] sum = new long[n];
        long[] flip = new long[n];
        long[] add = new long[n];
        for (int i = 0; i < n; i++) {
            sum[i] = nums2[i];
            if (i > 0) {
                sum[i] += sum[i - 1];
            }
        }
        for (int i = 0; i < q; i++) {
            if (queries[i][0] == 1) {
                int l = queries[i][1], r = queries[i][2];
                flip[l] ^= 1;
                flip[r + 1] ^= 1;
            } else if (queries[i][0] == 2) {
                int p = queries[i][1];
                add[0] += p;
            } else {
                long cur = 0;
                for (int j = 0; j < n; j++) {
                    cur += flip[j];
                    flip[j] = 0;
                    if ((cur & 1) == 1) {
                        res[i] += 1 - nums1[j];
                        nums1[j] = 1 - nums1[j];
                    }
                    res[i] += add[j] * nums1[j];
                    sum[j] += add[j];
                    add[j] = 0;
                }
                res[i] += sum[n - 1];
            }
        }
        return res;
    }
}