class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < min) {
                min = sum;
            }
        }
        return Math.max(max, -min);
    }
}