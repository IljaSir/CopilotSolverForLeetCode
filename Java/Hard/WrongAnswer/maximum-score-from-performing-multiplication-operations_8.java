class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        
        int n = nums.length;
        int m = multipliers.length;
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = i; j >= 0; j--) {
                if (j > 0) {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                dp[j] += nums[i - j] * multipliers[i];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (i >= n - m) {
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}