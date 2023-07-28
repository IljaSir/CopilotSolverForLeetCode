class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        
        int n = nums.length;
        long[] ans = new long[n];
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        for (int i = 0; i < n; i++) {
            idx[removeQueries[i]] = -1;
        }
        long sum = 0;
        long max = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (idx[i] == -1) {
                ans[cur++] = max;
                sum = 0;
                max = 0;
            } else {
                sum += nums[i];
                max = Math.max(max, sum);
                if (sum < 0) {
                    sum = 0;
                }
            }
        }
        ans[cur] = max;
        return ans;
    }
}