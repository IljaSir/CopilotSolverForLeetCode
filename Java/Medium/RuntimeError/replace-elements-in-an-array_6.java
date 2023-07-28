class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        
        int[] res = new int[nums.length];
        for (int i = 0; i < operations.length; i++) {
            int index = operations[i][0];
            int val = operations[i][1];
            nums[index] = val;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }
        return res;
    }
}