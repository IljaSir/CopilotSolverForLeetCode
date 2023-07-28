class Solution {
    public long kSum(int[] nums, int k) {
        
        int n = nums.length;
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
        long[] sums = new long[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++){
                sums[ix++] = dj] - dp[i - 1];
            }
        }
        Arrays.sort(sums);
        retursums[sums.length  k];
    }
}