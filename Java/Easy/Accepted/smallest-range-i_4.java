class Solution {
    public int smallestRangeI(int[] nums, int k) {
        
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        if (max - min > 2 * k) {
            return max - min - 2 * k;
        }
        return 0;
    }
}