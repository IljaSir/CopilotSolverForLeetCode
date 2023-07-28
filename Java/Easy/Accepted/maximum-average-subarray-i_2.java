class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        int sum = max;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }
}