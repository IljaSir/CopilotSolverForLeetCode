class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        if(nums.length == 0) return 0;
        int max = 1;
        int curr = 1;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] < nums[i+1]) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}