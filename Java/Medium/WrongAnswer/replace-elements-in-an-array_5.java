class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        int[] result = new int[nums.length];
        for (int[] operation : operations) {
            int from = operation[0];
            int to = operation[1];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == from) {
                    result[i] = to;
                }
            }
        }
        return result;
    }
}