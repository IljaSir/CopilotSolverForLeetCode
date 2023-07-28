class Solution {
    public boolean canBeIncreasing(int[] nums) {
        
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }
        right[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], nums[i]);
        }
        for (int i = 0; i < len; i++) {
            if (i == 0 && nums[i] < right[i + 1]) {
                return true;
            }
            if (i == len - 1 && nums[i] > left[i - 1]) {
                return true;
            }
            if (i > 0 && i < len - 1 && nums[i] > left[i - 1] && nums[i] < right[i + 1]) {
                return true;
            }
        }
        return false;
    }
}