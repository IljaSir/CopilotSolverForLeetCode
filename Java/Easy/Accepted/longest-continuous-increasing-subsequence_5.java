class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int max = 0;
        int count = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > prev) {
                count++;
                prev = nums[i];
            } else {
                max = Math.max(max, count);
                count = 1;
                prev = nums[i];
            }
        }
        max = Math.max(max, count);
        return max;
    }
}