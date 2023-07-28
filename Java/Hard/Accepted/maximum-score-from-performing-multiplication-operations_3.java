class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        
        int n = nums.length;
        int m = multipliers.length;
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int k = 1; k <= m; k++) {
            int[] ndp = new int[m + 1];
            Arrays.fill(ndp, Integer.MIN_VALUE);
            for (int i = 0; i <= k; i++) {
                int j = k - i;
                if (i > 0) {
                    ndp[i] = Math.max(ndp[i], dp[i - 1] + nums[i - 1] * multipliers[k - 1]);
                }
                if (j > 0) {
                    ndp[i] = Math.max(ndp[i], dp[i] + nums[n - j] * multipliers[k - 1]);
                }
            }
            dp = ndp;
        }
        int ans = Integer.MIN_VALUE;
        for (int x : dp) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}