class Solution {
    public int smallestRangeI(int[] nums, int k) {
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return Math.max(0, max - min - 2 * k);
    }
}