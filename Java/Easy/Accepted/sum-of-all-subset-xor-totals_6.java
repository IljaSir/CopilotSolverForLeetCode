class Solution {
    public int subsetXORSum(int[] nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += subsetXORSum(nums, i, nums[i]);
        }
        return sum;
    }

    public int subsetXORSum(int[] nums, int index, int xor) {
        if (index == nums.length - 1) {
            return xor;
        }
        int sum = 0;
        for (int i = index + 1; i < nums.length; i++) {
            sum += subsetXORSum(nums, i, xor ^ nums[i]);
        }
        return sum + xor;
    }
}