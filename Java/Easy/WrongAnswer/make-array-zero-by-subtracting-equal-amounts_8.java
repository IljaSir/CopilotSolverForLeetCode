class Solution {
    public int minimumOperations(int[] nums) {
        
        int min = 100;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min && nums[i]!=0){
                min = nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[i] = nums[i] - min;
                count++;
            }
        }
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                flag = true;
                break;
            }
        }
        if(flag){
            count = count + minimumOperations(nums);
        }
        return count;
    }
}