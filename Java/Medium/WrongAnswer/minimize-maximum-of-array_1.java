class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return Math.max(min, (sum - 1) / (nums.length - 1));
    }
}