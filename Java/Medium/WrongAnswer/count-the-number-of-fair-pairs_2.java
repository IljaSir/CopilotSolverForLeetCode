class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        long[] count = new long[upper - lower + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                long sum = prefixSum[j] - prefixSum[i];
                if (sum >= lower && sum <= upper) {
                    count[(int) (sum - lower)]++;
                }
            }
        }
        long ans = 0;
        for (long c : count) {
            ans += c * (c - 1) / 2;
        }
        return ans;
    }
}