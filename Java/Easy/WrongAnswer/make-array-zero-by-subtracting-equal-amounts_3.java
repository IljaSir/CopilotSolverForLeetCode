class Solution {
    public int minimumOperations(int[] nums) {
        
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                min = Math.min(min, nums[i]);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i] -= min;
                count++;
            }
        }
        return count + minimumOperations(nums);
    }
}