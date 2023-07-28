class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        int n = nums.length;
        long ans = 0;
        long sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            set.add(nums[i]);
            if (i >= k) {
                sum -= nums[i - k];
                set.remove(nums[i - k]);
            }
            if (i >= k - 1 && set.size() == k) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}