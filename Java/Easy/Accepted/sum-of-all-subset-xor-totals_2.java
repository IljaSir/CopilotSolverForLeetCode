class Solution {
    public int subsetXORSum(int[] nums) {
        
        return subsetXORSum(nums, 0, 0);
    }
    
    public int subsetXORSum(int[] nums, int i, int xor) {
        if (i == nums.length) {
            return xor;
        }
        return subsetXORSum(nums, i + 1, xor) + subsetXORSum(nums, i + 1, xor ^ nums[i]);
    }
}