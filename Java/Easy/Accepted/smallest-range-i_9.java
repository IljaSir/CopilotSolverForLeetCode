class Solution {
    public int smallestRangeI(int[] nums, int k) {
        
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return Math.max(max - min - 2 * k, 0);
    }
}