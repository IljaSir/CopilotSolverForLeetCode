class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        int result = original;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result) {
                result *= 2;
            }
        }
        return result;
    }
}