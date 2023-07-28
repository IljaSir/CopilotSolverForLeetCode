class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int max = 0;
        int curr = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}