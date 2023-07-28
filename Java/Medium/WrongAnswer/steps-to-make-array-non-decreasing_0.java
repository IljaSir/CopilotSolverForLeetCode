class Solution {
    public int totalSteps(int[] nums) {
        
        int steps = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                steps += nums[i - 1] - nums[i];
                nums[i] = nums[i - 1];
            }
        }
        return steps;
    }
}