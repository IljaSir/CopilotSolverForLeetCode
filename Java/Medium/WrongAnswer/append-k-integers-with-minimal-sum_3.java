class Solution {
    public long minimalKSum(int[] nums, int k) {
        
        long sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1] + 1) {
                if (k > nums[i] - (i == 0 ? 0 : nums[i - 1] + 1)) {
                    sum += (long) (nums[i] + nums[i] - (i == 0 ? 0 : nums[i - 1] + 1) + 1) * (nums[i] - (i == 0 ? 0 : nums[i - 1] + 1)) / 2;
                    k -= nums[i] - (i == 0 ? 0 : nums[i - 1] + 1);
                } else {
                    sum += (long) (nums[i] + nums[i] - k + 1) * k / 2;
                    return sum;
                }
            }
        }
        sum += (long) (nums[nums.length - 1] + nums[nums.length - 1] + k + 1) * k / 2;
        return sum;
    }
}