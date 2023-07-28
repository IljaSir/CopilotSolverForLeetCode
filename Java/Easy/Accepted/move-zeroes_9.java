class Solution {
    public void moveZeroes(int[] nums) {
        
        int l = nums.length;
        int i=0;
        int j=0;
        while(j<l){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
            j++;
        }
        while(i<l){
            nums[i]=0;
            i++;
        }
    }
}