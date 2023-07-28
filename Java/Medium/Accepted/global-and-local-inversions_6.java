class Solution {
    public boolean isIdealPermutation(int[] nums) {
        
        int n = nums.length;
        int max = nums[0];
        for (int i = 2; i < n; i++) {
            max = Math.max(max, nums[i - 2]);
            if (max > nums[i]) {
                return false;
            }
        }
        return true;
    }
}