class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int maxSum = 0;
        int max = 0;
        int minSum = 0;
        int min = 0;
        for (int i = 0; i < nums.length; ++i) {
            maxSum += nums[i];
            minSum += nums[i];
            max = Math.max(max, maxSum);
            min = Math.min(min, minSum);
            if (maxSum < 0) maxSum = 0;
            if (minSum > 0) minSum = 0;
        }
        return Math.max(max, -min);
    }
}