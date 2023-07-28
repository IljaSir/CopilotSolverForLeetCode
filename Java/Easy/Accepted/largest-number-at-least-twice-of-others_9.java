class Solution {
    public int dominantIndex(int[] nums) {
        
        int max = 0, second = 0;
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                second = max;
                max = nums[i];
                maxIdx = i;
            } else if (nums[i] >= second) {
                second = nums[i];
            }
        }
        return (max >= 2 * second) ? maxIdx : -1;
    }
}