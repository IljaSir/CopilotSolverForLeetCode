class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int n = nums.length;
        double[] sum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        double max = sum[k] - sum[0];
        for (int i = k; i < n; i++) {
            max = Math.max(max, sum[i + 1] - sum[i - k + 1]);
        }
        return max / k;
    }
}