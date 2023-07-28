class Solution {
    public int findMaxK(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(max, nums[i]);
            }
        }
        return max;
    }
    public int largestInteger(int[] nums) {
        int max = findMaxK(nums);
        if (max == 0) {
            return -1;
        }
        for (int i = max; i > 0; i--) {
            if (Arrays.binarySearch(nums, -i) >= 0) {
                return i;
            }
        }
        return -1;
    }
}