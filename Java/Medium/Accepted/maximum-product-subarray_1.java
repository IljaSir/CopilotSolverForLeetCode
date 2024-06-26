class Solution {
    public int maxProduct(int[] nums) {
        
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            min = Math.min(nums[i], Math.min(min * nums[i], temp * nums[i]));
            result = Math.max(result, max);
        }
        return result;
    }
}