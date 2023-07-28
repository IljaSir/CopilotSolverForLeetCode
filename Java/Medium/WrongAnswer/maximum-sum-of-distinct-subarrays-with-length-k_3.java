class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        long max = 0;
        long sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            set.add(nums[i]);
            if (i >= k) {
                sum -= nums[i - k];
                set.remove(nums[i - k]);
            }
            if (i >= k - 1) {
                max = Math.max(max, sum - set.first());
            }
        }
        return max;
    }
}