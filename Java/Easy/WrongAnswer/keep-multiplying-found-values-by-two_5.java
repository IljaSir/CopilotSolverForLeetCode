class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        int i = 0;
        while(i < nums.length && nums[i] != original) {
            i++;
        }
        if(i < nums.length) {
            return 2 * original;
        } else {
            return original;
        }
    }
}