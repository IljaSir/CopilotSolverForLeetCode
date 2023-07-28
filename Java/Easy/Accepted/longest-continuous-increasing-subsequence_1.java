class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 1;
            }
        }
        return Math.max(count, max);
    }
}