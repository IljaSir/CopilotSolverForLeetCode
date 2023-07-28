class Solution {
    public int findMaxK(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n-1];
        int min = nums[0];
        if(min > 0) return -1;
        if(min < 0 && max < 0) return -min;
        if(min < 0 && max > 0){
            int i = 0;
            int j = n-1;
            int k = 0;
            while(i < j){
                if(nums[i] == -nums[j]){
                    k = nums[i];
                    break;
                }else if(nums[i] < -nums[j]){
                    i++;
                }else{
                    j--;
                }
            }
            return k;
        }
        return -1;
    }
}