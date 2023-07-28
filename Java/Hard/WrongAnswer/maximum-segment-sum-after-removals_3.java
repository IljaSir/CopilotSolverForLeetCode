class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        
        int n = nums.length;
        long[] res = new long[n];
        long[] presum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        long[] max = new long[n + 1];
        for (int i = 0; i < n; i++) {
            max[i] = presum[i + 1];
        }
        for (int i = n - 1; i > 0; i--) {
            max[i] = Math.max(max[i], max[i + 1]);
        }
        boolean[] removed = new boolean[n];
        for (int i = 0; i < n; i++) {
            removed[removeQueries[i]] = true;
            long sum = 0;
            for (int j = removeQueries[i]; j < n; j++) {
                if (!removed[j]) {
                    sum += nums[j];
                }
                if (j + 1 < n && !removed[j + 1]) {
                    max[j + 1] = Math.max(max[j + 1], sum);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = max[i];
        }
        return res;
    }
}