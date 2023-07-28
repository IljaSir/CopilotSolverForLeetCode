class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        
        int n = nums.length;
        int[] removed = new int[n];
        for (int i = 0; i < n; i++) {
            removed[removeQueries[i]] = 1;
        }
        long[] res = new long[n];
        long sum = 0;
        long max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (removed[i] == 0) {
                sum += nums[i];
                max = Math.max(max, sum);
            } else {
                count++;
                res[n - count] = max;
                sum = 0;
                max = 0;
            }
        }
        count++;
        res[n - count] = max;
        for (int i = n - count - 1; i >= 0; i--) {
            res[i] = res[i + 1];
        }
        return res;
    }
}