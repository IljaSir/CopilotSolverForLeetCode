class Solution {
    public int repeatedNTimes(int[] nums) {
        
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[(len/2)-1] == nums[len/2]) {
            return nums[len/2];
        } else {
            return nums[len/2-1];
        }
    }
}