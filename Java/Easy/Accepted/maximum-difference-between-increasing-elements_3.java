class Solution {
    public int maximumDifference(int[] nums) {
        
        int max = -1;
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > min) {
                max = Math.max(max, nums[i] - min);
            }
            min = Math.min(min, nums[i]);
        }
        return max;
    }
}