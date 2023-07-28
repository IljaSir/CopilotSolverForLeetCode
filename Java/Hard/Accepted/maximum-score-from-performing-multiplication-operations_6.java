class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        
        int n = nums.length;
        int m = multipliers.length;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            int[] ndp = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                int k = i - j;
                ndp[j] = Integer.MIN_VALUE;
                if (j > 0) {
                    ndp[j] = Math.max(ndp[j], dp[j - 1] + multipliers[i - 1] * nums[j - 1]);
                }
                if (k > 0) {
                    ndp[j] = Math.max(ndp[j], dp[j] + multipliers[i - 1] * nums[n - k]);
                }
            }
            dp = ndp;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}