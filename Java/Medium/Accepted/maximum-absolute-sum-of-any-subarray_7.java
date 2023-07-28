class Solution {
    public int maxAbsoluteSum(int[] nums) {
        
        int maxSum = 0;
        int minSum = 0;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, Math.abs(sum - minSum));
            max = Math.max(max, Math.abs(sum - maxSum));
            maxSum = Math.max(maxSum, sum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}