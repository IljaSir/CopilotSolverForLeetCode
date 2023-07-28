class Solution {
    public int subsetXORSum(int[] nums) {
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }
        return sum * (int) Math.pow(2, nums.length - 1);
    }
}