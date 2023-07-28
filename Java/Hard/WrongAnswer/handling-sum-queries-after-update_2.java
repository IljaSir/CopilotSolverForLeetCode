class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        
        int n = nums1.length;
        long[] ans = new long[queries.length];
        int index = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                for (int i = query[1]; i <= query[2]; i++) {
                    nums1[i] ^= 1;
                }
            } else if (query[0] == 2) {
                for (int i = 0; i < n; i++) {
                    nums2[i] += nums1[i] * query[1];
                }
            } else {
                long sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += nums2[i];
                }
                ans[index++] = sum;
            }
        }
        return ans;
    }
}