class Solution {
    public int dominantIndex(int[] nums) {
        
        int max = 0;
        int maxIndex = 0;
        int secondMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (max >= secondMax * 2) {
            return maxIndex;
        } else {
            return -1;
        }
    }
}