class Solution {
    public int maximumDifference(int[] nums) {
        
        int max = -1;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - min;
            if (diff > max) {
                max = diff;
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return max;
    }
}