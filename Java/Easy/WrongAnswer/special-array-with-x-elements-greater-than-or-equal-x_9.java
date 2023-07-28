class Solution {
    public int specialArray(int[] nums) {
        
        Arrays.sort(nums);
        int x = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] >= x + 1){
                x++;
            }else{
                break;
            }
        }
        return x;
    }
}