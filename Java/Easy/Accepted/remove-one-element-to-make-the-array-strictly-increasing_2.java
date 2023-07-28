class Solution {
    public boolean canBeIncreasing(int[] nums) {
        
        int index = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                if (index != -1) {
                    return false;
                }
                index = i;
            }
        }
        if (index == -1 || index == 1 || index == nums.length - 1) {
            return true;
        }
        if (nums[index - 1] < nums[index + 1] || nums[index - 2] < nums[index]) {
            return true;
        }
        return false;
    }
}