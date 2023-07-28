class Solution {
    public int minimumDeletions(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int countMin = 0;
        int countMax = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == min){
                countMin++;
            }
            if(nums[i] == max){
                countMax++;
            }
            if(nums[i] < min){
                min = nums[i];
                countMin = 1;
            }
            if(nums[i] > max){
                max = nums[i];
                countMax = 1;
            }
        }
        
        return nums.length - countMin - countMax;
    }
}