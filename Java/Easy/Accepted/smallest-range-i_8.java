class Solution {
    public int smallestRangeI(int[] nums, int k) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int range = max - min;
        if (range <= 2 * k) {
            return 0;
        } else {
            return range - 2 * k;
        }
    }
}