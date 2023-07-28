class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        
        int n = nums1.length;
        long[] res = new long[queries.length];
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i] + nums1[i];
        }
        long sum = 0;
        int index = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                int l = query[1], r = query[2];
                sum += (r - l + 1) % 2 * (count[r + 1] - count[l]);
            } else if (query[0] == 2) {
                sum += query[1] * n;
            } else {
                res[index++] = sum;
            }
        }
        return Arrays.copyOf(res, index);
    }
}