class Solution {
    public boolean isMonotonic(int[] nums) {
        
        if (nums.length == 1) {
            return true;
        }
        boolean isIncreasing = nums[0] <= nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (isIncreasing) {
                if (nums[i] < nums[i - 1]) {
                    return false;
                }
            } else {
                if (nums[i] > nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}