class Solution {
    public int majorityElement(int[] nums) {
        
        int count=0;
        int candidate=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidate=nums[i];
            }
            count+=candidate==nums[i]?1:-1;
        }
        return candidate;
    }
}