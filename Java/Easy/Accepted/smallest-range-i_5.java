class Solution {
    public int smallestRangeI(int[] nums, int k) {
        
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return Math.max(0, max - min - 2 * k);
    }
}