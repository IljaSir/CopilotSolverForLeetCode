class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        int res = original;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res) {
                res *= 2;
            }
        }
        return res;
    }
}