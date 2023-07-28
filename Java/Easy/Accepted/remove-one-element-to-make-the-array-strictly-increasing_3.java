class Solution {
    public boolean canBeIncreasing(int[] nums) {
        
        int count = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i-1]) {
                count++;
                if(i == 1 || i == nums.length-1) {
                    continue;
                }
                if(nums[i] > nums[i-2]) {
                    nums[i-1] = nums[i-2];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return count <= 1;
    }
}