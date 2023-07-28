class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                if(count++ > 0) {
                    return false;
                }
                if(i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}