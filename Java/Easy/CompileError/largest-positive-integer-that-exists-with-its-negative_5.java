class Solution {
    public int findMaxK(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }
    
    public int findMinK(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }
    
    public int largestInteger(int[] nums) {
        int max = findMaxK(nums);
        int min = findMinK(nums);
        if(min<0){
            if(min*-1==max){
                return max;
            }
            else{
                return -1;
            }
        }
        else{
            return -1;
        }
    }
}
    }
}