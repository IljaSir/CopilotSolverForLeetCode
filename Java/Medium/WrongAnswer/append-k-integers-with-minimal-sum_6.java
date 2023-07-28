class Solution {
    public long minimalKSum(int[] nums, int k) {
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        long sum = 0;
        int i = 0;
        while (k > 0) {
            if (i < nums.length - 1 && nums[i] + 1 < nums[i + 1]) {
                sum += nums[i] + 1;
                i++;
                k--;
            } else if (i == nums.length - 1) {
                sum += nums[i] + k;
                k = 0;
            } else {
                i++;
            }
        }
        return sum;
    }
}