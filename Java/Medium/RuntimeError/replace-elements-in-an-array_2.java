class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        for (int[] operation : operations) {
            int index = operation[0] - 1;
            int value = operation[1];
            result[index] = value;
        }
        return result;
    }
}