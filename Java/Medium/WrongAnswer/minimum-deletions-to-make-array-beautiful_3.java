class Solution {
    public int minDeletion(int[] nums) {
        
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                count++;
                i++;
            }
        }
        return count;
    }
}