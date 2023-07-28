class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        int[] result = new int[nums.length];
        for (int i = 0; i < operations.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == operations[i][0]) {
                    nums[j] = operations[i][1];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        return result;
    }
}