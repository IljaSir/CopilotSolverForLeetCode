class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        
        long max = 0;
        int i = 0;
        int j = 0;
        int n = nums.length;
        long sum = 0;
        Set<Integer> set = new HashSet<>();
        while (j < n) {
            if (set.contains(nums[j])) {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            } else {
                max = Math.max(max, sum);
                set.add(nums[j]);
                sum += nums[j];
                j++;
            }
            if (j - i == k) {
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        return max;
    }
}