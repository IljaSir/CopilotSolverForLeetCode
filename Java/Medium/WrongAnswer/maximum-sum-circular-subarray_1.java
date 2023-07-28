class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        // max subarray sum
        int res = nums[0];
        int cur = nums[0];
        for (int i = 1; i < n; i++) {
            cur = nums[i] + Math.max(cur, 0);
            res = Math.max(res, cur);
        }
        // min subarray sum
        int minSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minSum = Math.min(minSum, sum[i]);
            min = Math.min(min, sum[i] - minSum);
        }
        return Math.max(res, sum[n] - min);
    }
}