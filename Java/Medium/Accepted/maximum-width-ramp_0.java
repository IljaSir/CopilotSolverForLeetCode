class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] >= nums[i]) {
                    max = Math.max(max, j - i);
                    break;
                }
            }
        }
        return max;
    }
}