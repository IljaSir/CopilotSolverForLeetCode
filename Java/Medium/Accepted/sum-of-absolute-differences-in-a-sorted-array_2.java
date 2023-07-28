class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 0 : prefixSum[i - 1];
            int right = i == n - 1 ? 0 : suffixSum[i + 1];
            result[i] = nums[i] * i - left + right - nums[i] * (n - i - 1);
        }
        return result;
    }
}