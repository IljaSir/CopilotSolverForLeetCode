class Solution {
    public boolean isMonotonic(int[] nums) {
        
        if (nums.length == 1) {
            return true;
        }
        int i = 0;
        while (i < nums.length-1 && nums[i] == nums[i+1]) {
            i++;
        }
        if (i == nums.length-1) {
            return true;
        }
        boolean increasing = nums[i] < nums[i+1];
        for (int j = i; j < nums.length-1; j++) {
            if (increasing && nums[j] > nums[j+1]) {
                return false;
            } else if (!increasing && nums[j] < nums[j+1]) {
                return false;
            }
        }
        return true;
    }
}