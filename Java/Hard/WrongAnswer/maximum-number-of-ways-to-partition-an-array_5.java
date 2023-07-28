class Solution {
    public int waysToPartition(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];
        prefixSum[0] = nums[0];
        suffixSum[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                max++;
            }
        }
        int diff = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 0 : prefixSum[i - 1];
            int right = i == n - 1 ? 0 : suffixSum[i + 1];
            if (left + k == right + k) {
                diff = Math.max(diff, 1);
            }
            if (left + k == right) {
                diff = Math.max(diff, 1);
            }
            if (left == right + k) {
                diff = Math.max(diff, 1);
            }
        }
        return diff == Integer.MIN_VALUE ? max : max + diff;
    }
}