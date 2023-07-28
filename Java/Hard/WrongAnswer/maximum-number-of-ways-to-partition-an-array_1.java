class Solution {
    public int waysToPartition(int[] nums, int k) {
        
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        long[] prefix = new long[n + 1];
        long[] suffix = new long[n + 1];
        long[] prefixMax = new long[n + 1];
        long[] suffixMax = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = sum[i] - Math.min(sum[i], sum[n] - sum[i]);
            prefixMax[i] = Math.max(prefixMax[i - 1], prefix[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = sum[n] - sum[i] - Math.min(sum[i], sum[n] - sum[i]);
            suffixMax[i] = Math.max(suffixMax[i + 1], suffix[i]);
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, (int) (prefixMax[i] + suffixMax[i]));
        }
        for (int i = 0; i < n; i++) {
            nums[i] = k;
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 1; i <= n; i++) {
            prefix[i] = sum[i] - Math.min(sum[i], sum[n] - sum[i]);
            prefixMax[i] = Math.max(prefixMax[i - 1], prefix[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = sum[n] - sum[i] - Math.min(sum[i], sum[n] - sum[i]);
            suffixMax[i] = Math.max(suffixMax[i + 1], suffix[i]);
        }
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, (int) (prefixMax[i] + suffixMax[i]));
        }
        return ans;
    }
}