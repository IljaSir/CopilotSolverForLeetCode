class Solution {
    public int maximumSum(int[] nums) {
        
        int max = -1;
        int maxSum = -1;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            int n = nums[i];
            while(n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (sum > max) {
                max = sum;
                maxSum = nums[i];
            } else if (sum == max) {
                maxSum = Math.max(maxSum, nums[i]);
            }
        }
        return maxSum;
    }
}