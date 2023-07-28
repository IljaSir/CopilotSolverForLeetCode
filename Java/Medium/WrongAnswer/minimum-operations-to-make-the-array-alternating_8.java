class Solution {
    public int minimumOperations(int[] nums) {
        
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(i%2 == 0) {
                if(nums[i]%2 != 0) {
                    continue;
                } else {
                    count++;
                }
            } else {
                if(nums[i]%2 == 0) {
                    continue;
                } else {
                    count++;
                }
            }
        }
        return Math.min(count, nums.length-count);
    }
}