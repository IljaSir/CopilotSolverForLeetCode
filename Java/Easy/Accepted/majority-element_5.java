class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 1;
        int candidate = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                candidate = nums[i];
            }
            if(candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}