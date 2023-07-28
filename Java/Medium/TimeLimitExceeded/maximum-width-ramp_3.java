class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > max; j--) {
                if (nums[i] <= nums[j]) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
}