class Solution {
    public int minimumOperations(int[] nums) {
        
        int count = 0;
        int min = 100;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 && nums[i] < min){
                min = nums[i];
            }
        }
        if(min == 100){
            return 0;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[i] = nums[i] - min;
                count++;
            }
        }
        return count + minimumOperations(nums);
    }
}
    }
}