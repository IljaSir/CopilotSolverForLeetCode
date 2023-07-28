class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        
        int n = nums1.length;
        long[] preSum = new long[n];
        long[] res = new long[queries.length];
        for (int i = 0; i < n; ++i) {
            preSum[i] = nums2[i];
            if (i > 0) {
                preSum[i] += preSum[i - 1];
            }
        }
        for (int i = 0; i < queries.length; ++i) {
            if (queries[i][0] == 1) {
                for (int j = queries[i][1]; j <= queries[i][2]; ++j) {
                    nums1[j] ^= 1;
                }
            } else if (queries[i][0] == 2) {
                for (int j = 0; j < n; ++j) {
                    nums2[j] += nums1[j] * queries[i][1];
                }
                for (int j = 0; j < n; ++j) {
                    preSum[j] = nums2[j];
                    if (j > 0) {
                        preSum[j] += preSum[j - 1];
                    }
                }
            } else {
                res[i] = preSum[queries[i][2]];
                if (queries[i][1] > 0) {
                    res[i] -= preSum[queries[i][1] - 1];
                }
            }
        }
        return res;
    }
}