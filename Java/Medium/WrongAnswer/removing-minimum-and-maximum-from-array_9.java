class Solution {
    public int minimumDeletions(int[] nums) {
        
        int min = 0, max = nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            } else if (nums[i] > nums[max]) {
                max = i;
            }
        }
        if (min < max) {
            return min + nums.length - 1 - max;
        }
        return min + nums.length - 2 - max;
    }
}