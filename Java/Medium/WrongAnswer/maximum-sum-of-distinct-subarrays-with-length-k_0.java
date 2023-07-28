class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        long ans = 0;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                set.add(sum[i - k]);
            }
            if (set.size() > 0) {
                ans = Math.max(ans, sum[i] - set.first());
            }
        }
        return ans;
    }
}