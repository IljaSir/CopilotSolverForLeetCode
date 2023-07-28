class Solution {
    public int findLengthOfLCIS(int[] nums) {
        
        int max = 1;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                current++;
                max = Math.max(max, current);
            } else {
                current = 1;
            }
        }
        return max;
    }
}