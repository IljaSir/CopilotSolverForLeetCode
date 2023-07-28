class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        
        int n = nums1.length;
        long[] res = new long[queries.length];
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums2[i];
        }
        int[] count = new int[n + 1];
        int idx = 0;
        for (int[] query : queries) {
            int type = query[0];
            if (type == 1) {
                int l = query[1], r = query[2];
                count[l]++;
                count[r + 1]--;
            } else if (type == 2) {
                int p = query[1];
                for (int i = 1; i <= n; i++) {
                    count[i] += count[i - 1];
                    sum[i] += count[i] * p;
                }
                Arrays.fill(count, 0);
            } else {
                int l = query[1], r = query[2];
                res[idx++] = sum[r + 1] - sum[l];
            }
        }
        return res;
    }
}