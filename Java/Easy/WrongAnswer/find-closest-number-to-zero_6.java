class Solution {
    public int findClosestNumber(int[] nums) {
        
        int min = 100000;
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i]) < min) {
                min = Math.abs(nums[i]);
                result = nums[i];
            }
            if(Math.abs(nums[i]) == min) {
                result = Math.max(result, nums[i]);
            }
        }
        return result;
    }
}