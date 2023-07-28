class Solution {
    public int maxProduct(int[] nums) {
        
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxSoFar;
            maxSoFar = Math.max(nums[i], Math.max(nums[i] * maxSoFar, nums[i] * minSoFar));
            minSoFar = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * minSoFar));
            result = Math.max(result, maxSoFar);
        }
        return result;
    }
}