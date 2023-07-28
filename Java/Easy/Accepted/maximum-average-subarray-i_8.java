class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double max = -10000;
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                max = Math.max(max, sum / k);
                sum -= nums[i - k + 1];
            }
        }
        return max;
    }
}