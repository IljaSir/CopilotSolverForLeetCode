class Solution {
    public int dominantIndex(int[] nums) {
        
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == maxIndex) {
                continue;
            }
            if (nums[i] * 2 > max) {
                return -1;
            }
        }
        return maxIndex;
    }
}