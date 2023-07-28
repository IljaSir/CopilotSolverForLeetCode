class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        
        int n = nums1.length;
        int q = queries.length;
        long[] res = new long[q];
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = nums1[i] * nums2[i];
        }
        for (int i = 0; i < q; i++) {
            if (queries[i][0] == 1) {
                int l = queries[i][1];
                int r = queries[i][2];
                for (int j = l; j <= r; j++) {
                    s[j] = 1 - nums1[j] * nums2[j];
                }
            } else if (queries[i][0] == 2) {
                int p = queries[i][1];
                for (int j = 0; j < n; j++) {
                    nums2[j] += p * nums1[j];
                    s[j] = nums1[j] * nums2[j];
                }
            } else {
                long sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += s[j];
                }
                res[i] = sum;
            }
        }
        return res;
    }
}