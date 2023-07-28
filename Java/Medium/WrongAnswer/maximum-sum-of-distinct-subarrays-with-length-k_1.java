class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        long[] max = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            max[i] = Math.max(max[i - 1], prefix[i]);
        }
        long result = 0;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = k; i <= nums.length; i++) {
            set.add(prefix[i - k]);
            result = Math.max(result, max[i - k] + prefix[i] - set.first());
        }
        return result;
    }
}