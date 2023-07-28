class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        
        long[] result = new long[queries.length];
        int index = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                for (int i = query[1]; i <= query[2]; i++) {
                    nums1[i] = nums1[i] == 1 ? 0 : 1;
                }
            } else if (query[0] == 2) {
                for (int i = 0; i < nums2.length; i++) {
                    nums2[i] += nums1[i] * query[1];
                }
            } else if (query[0] == 3) {
                long sum = 0;
                for (int i = 0; i < nums2.length; i++) {
                    sum += nums2[i];
                }
                result[index++] = sum;
            }
        }
        return result;
    }
}