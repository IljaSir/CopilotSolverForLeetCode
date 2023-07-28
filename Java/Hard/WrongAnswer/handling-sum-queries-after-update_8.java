class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        
        int N = nums1.length;
        int Q = queries.length;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = nums1[i] * nums2[i];
        }
        int[] b = new int[N];
        long[] ans = new long[Q];
        int ansIdx = 0;
        for (int[] query : queries) {
            int type = query[0];
            int x = query[1];
            int y = query[2];
            if (type == 1) {
                for (int i = x; i <= y; i++) {
                    a[i] = nums1[i] * (1 - nums2[i]);
                    b[i] = (1 - nums1[i]) * nums2[i];
                    nums1[i] = 1 - nums1[i];
                    nums2[i] = 1 - nums2[i];
                }
            } else if (type == 2) {
                for (int i = 0; i < N; i++) {
                    b[i] += x * a[i];
                }
            } else {
                long sum = 0;
                for (int i = 0; i < N; i++) {
                    sum += b[i];
                }
                ans[ansIdx++] = sum;
            }
        }
        return ans;
    }
}