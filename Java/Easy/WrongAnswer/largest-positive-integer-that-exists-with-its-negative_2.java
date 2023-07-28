class Solution {
    public int findMaxK(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(max, nums[i]);
            }
        }
        if (max == Integer.MIN_VALUE) {
            return -1;
        }
        return max;
    }
    public int findMinK(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                min = Math.min(min, nums[i]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
    public int largestInteger(int[] nums) {
        int max = findMaxK(nums);
        int min = findMinK(nums);
        if (max == -1 || min == -1) {
            return -1;
        }
        if (max == -min) {
            return max;
        }
        return -1;
    }
}