class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int[] maxPrefixSum = new int[n];
        maxPrefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxPrefixSum[i] = Math.max(maxPrefixSum[i - 1], prefixSum[i]);
        }
        int[] maxSuffixSum = new int[n];
        maxSuffixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxSuffixSum[i] = Math.max(maxSuffixSum[i + 1], prefixSum[n - 1] - prefixSum[i]);
        }
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            maxSum = Math.max(maxSum, maxPrefixSum[i - 1] + maxSuffixSum[i]);
        }
        return maxSum;
    }
}