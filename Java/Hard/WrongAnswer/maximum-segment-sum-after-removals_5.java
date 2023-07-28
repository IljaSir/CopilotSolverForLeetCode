class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        
        int n = nums.length;
        long[] res = new long[n];
        Set<Integer> removed = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            removed.add(removeQueries[i]);
            res[i] = helper(nums, removed);
        }
        return res;
    }
    private long helper(int[] nums, Set<Integer> removed) {
        long res = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!removed.contains(i)) {
                sum += nums[i];
                res = Math.max(res, sum);
            } else {
                sum = 0;
            }
        }
        return res;
    }
}