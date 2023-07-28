class Solution {
    public boolean isIdealPermutation(int[] nums) {
        
        int len = nums.length;
        int max = nums[0];
        for (int i = 2; i < len; i++) {
            if (max > nums[i]) {
                return false;
            }
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }
}