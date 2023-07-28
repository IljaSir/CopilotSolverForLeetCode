class Solution {
    public int minimizeArrayValue(int[] nums) {
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return Math.max(sum / (nums.length - 1), (sum + nums.length - 2) / (nums.length - 1));
    }
}