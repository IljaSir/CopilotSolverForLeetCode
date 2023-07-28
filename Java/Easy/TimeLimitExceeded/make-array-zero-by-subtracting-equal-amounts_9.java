class Solution {
    public int minimumOperations(int[] nums) {
        
        int count = 0;
        int min = 101;
        boolean flag = true;
        while(flag){
            flag = false;
            min = 101;
            for(int i=0;i<nums.length;i++){
                if(nums[i] != 0){
                    flag = true;
                    if(nums[i] < min){
                        min = nums[i];
                    }
                }
            }
            if(flag){
                count++;
                for(int i=0;i<nums.length;i++){
                    nums[i] = nums[i] - min;
                }
            }
        }
        return count;
    }
}