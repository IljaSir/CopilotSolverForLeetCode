class Solution {
    public boolean isMonotonic(int[] nums) {
        
        int i, n = nums.length;
        boolean isIncreasing = true, isDecreasing = true;
        for (i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                isIncreasing = false;
            }
            if (nums[i] < nums[i + 1]) {
                isDecreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }
}