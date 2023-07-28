class Solution {
    public boolean canBeIncreasing(int[] nums) {
        
        int len = nums.length;
        if(len == 2){
            return true;
        }
        int index = -1;
        for(int i = 1; i < len; i++){
            if(nums[i] <= nums[i - 1]){
                if(index != -1){
                    return false;
                }
                index = i;
            }
        }
        if(index == -1){
            return true;
        }
        if(index == 1 || index == len - 1){
            return true;
        }
        if(nums[index - 1] < nums[index + 1]){
            return true;
        }
        if(nums[index - 2] < nums[index]){
            return true;
        }
        return false;
    }
}