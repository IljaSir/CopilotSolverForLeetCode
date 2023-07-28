class Solution {
    public long minimumReplacement(int[] nums) {
        
        long res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                res++;
            }else{
                if(i < nums.length - 1 && nums[i + 1] % 2 == 0){
                    res++;
                    i++;
                }else{
                    res += 2;
                }
            }
        }
        return res;
    }
}