class Solution {
    public int maxAscendingSum(int[] nums) {
        
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i == nums.length - 1 || nums[i] >= nums[i + 1]) {
                maxSum = Math.max(maxSum, sum);
                sum = 0;
            }
        }
        return maxSum;
    }
}