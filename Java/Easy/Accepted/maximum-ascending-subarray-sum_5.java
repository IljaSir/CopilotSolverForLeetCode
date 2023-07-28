class Solution {
    public int maxAscendingSum(int[] nums) {
        
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sum = nums[i];
            } else if (nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}