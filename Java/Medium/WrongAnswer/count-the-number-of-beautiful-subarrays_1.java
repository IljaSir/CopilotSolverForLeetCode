class Solution {
    public long beautifulSubarrays(int[] nums) {
        
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            int odd = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] % 2 == 1){
                    odd++;
                }
                if(odd % 2 == 1){
                    count++;
                }
            }
        }
        return count;
    }
}